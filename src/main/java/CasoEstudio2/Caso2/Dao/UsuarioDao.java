package CasoEstudio2.Caso2.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import CasoEstudio2.Caso2.domain.Usuarios;

public interface UsuarioDao extends JpaRepository<Usuarios, Long> {

    // Buscar usuario por username (Spring Security lo usa)
    Usuarios findByNombre(String nombre);

    // Buscar por username y contraseña (no recomendado para producción, mejor usar Spring Security para validar)
    Usuarios findByNombreAndContrasena(String nombre, String contrasena);

    // Buscar si ya existe un usuario por username o correo (útil al registrar)
    Usuarios findByNombreOrCorreo(String nombre, String correo);

}
