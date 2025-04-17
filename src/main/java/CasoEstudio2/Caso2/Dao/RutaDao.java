package CasoEstudio2.Caso2.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import CasoEstudio2.Caso2.domain.Ruta;

public interface RutaDao extends JpaRepository<Ruta, Long> {

    // Buscar rutas asociadas a un rol específico
    List<Ruta> findByRolName(String rolName);
}