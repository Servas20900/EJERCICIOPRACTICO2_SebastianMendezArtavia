package CasoEstudio2.Caso2.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CasoEstudio2.Caso2.Dao.UsuarioDao;
import CasoEstudio2.Caso2.domain.Usuario;
import CasoEstudio2.Caso2.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getId_usuario()).orElse(null);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}