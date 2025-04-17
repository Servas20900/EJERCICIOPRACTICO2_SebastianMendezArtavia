package CasoEstudio2.Caso2.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import CasoEstudio2.Caso2.domain.Rol;

public interface RolDao extends JpaRepository<Rol, Long> {

    List<Rol> findByIdUsuario(Long id);
    
    List<Rol> findByNombre(String nombre);
}