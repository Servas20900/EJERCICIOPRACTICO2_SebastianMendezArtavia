package CasoEstudio2.Caso2.Dao;


import CasoEstudio2.Caso2.domain.Reserva;
import CasoEstudio2.Caso2.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuario(Usuario usuario);
}