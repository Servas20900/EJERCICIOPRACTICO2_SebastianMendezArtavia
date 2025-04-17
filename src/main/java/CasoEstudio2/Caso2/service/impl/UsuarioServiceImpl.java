package CasoEstudio2.Caso2.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CasoEstudio2.Caso2.Dao.UsuarioDao;
import CasoEstudio2.Caso2.domain.Usuarios;
import CasoEstudio2.Caso2.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuarios> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuarios getUsuario(Usuarios usuario) {
        return usuarioDao.findById(usuario.getId()).orElse(null);
    }

    @Override
    public Usuarios getUsuarioPorNombre(String nombre) {
        return usuarioDao.findByNombre(nombre);
    }

    @Override
    public Usuarios getUsuarioPorNombreYContrasena(String nombre, String contrasena) {
        return usuarioDao.findByNombreAndContrasena(nombre, contrasena);
    }

    @Override
    public Usuarios getUsuarioPorNombreOCorreo(String nombre, String correo) {
        return usuarioDao.findByNombreOrCorreo(nombre, correo);
    }

    @Override
    public void save(Usuarios usuario) {
        // En esta implementación básica ignoramos el parámetro crearRolUser
        usuarioDao.save(usuario);
    }

    @Override
    public void delete(Usuarios usuario) {
        usuarioDao.delete(usuario);
    }
}