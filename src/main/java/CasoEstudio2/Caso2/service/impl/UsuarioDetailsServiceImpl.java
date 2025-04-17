package CasoEstudio2.Caso2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CasoEstudio2.Caso2.Dao.UsuarioDao;
import CasoEstudio2.Caso2.domain.Rol;
import CasoEstudio2.Caso2.domain.Usuarios;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        // Busca el usuario por nombre
        Usuarios usuario = usuarioDao.findByNombre(nombre);

        // Si no existe el usuario, lanza una excepción
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre: " + nombre);
        }

        // Construir lista de roles
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        // Devolver objeto User que Spring Security usa internamente
        return new User(usuario.getNombre(), usuario.getContrasena(), roles);
    }
}
