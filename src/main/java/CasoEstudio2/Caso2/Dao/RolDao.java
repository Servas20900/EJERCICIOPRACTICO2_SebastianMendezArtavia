package CasoEstudio2.Caso2.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import CasoEstudio2.Caso2.domain.Rol;

public interface RolDao extends JpaRepository<Rol, Long> {

    // Buscar todos los roles asociados a un usuario por el id del usuario
    List<Rol> findByUsuario_Id(Long usuarioId);

    // Buscar por nombre de rol
    List<Rol> findByNombre(String nombre);
}
