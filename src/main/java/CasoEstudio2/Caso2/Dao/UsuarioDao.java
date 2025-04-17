package CasoEstudio2.Caso2.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import CasoEstudio2.Caso2.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    // Buscar usuario por username (Spring Security lo usa)
    Usuario findByUsername(String username);

    // Buscar por username y contraseña (no recomendado para producción, mejor usar Spring Security para validar)
    Usuario findByUsernameAndPassword(String username, String password);

    // Buscar si ya existe un usuario por username o correo (útil al registrar)
    Usuario findByUsernameOrCorreo(String username, String correo);

}
