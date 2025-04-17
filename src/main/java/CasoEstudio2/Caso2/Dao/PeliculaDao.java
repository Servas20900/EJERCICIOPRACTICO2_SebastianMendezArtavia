package CasoEstudio2.Caso2.Dao;

import CasoEstudio2.Caso2.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository<Pelicula, Long> {
    
}
