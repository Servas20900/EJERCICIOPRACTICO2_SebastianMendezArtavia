package CasoEstudio2.Caso2.service;


import java.util.List;
import CasoEstudio2.Caso2.domain.Usuarios;

public interface UsuarioService {
    
    // Se obtiene un listado de usuarios en un List
    public List<Usuarios> getUsuarios();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuarios getUsuario(Usuarios usuario);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Usuarios getUsuarioPorNombre(String nombre);

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuarios getUsuarioPorNombreYContrasena(String nombre, String contrasena);
    
    // Se obtiene un Usuario, a partir del username o el correo del usuario
    public Usuarios getUsuarioPorNombreOCorreo(String nombre, String correo);
    
    public void save(Usuarios usuario);
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuarios usuario);
}
