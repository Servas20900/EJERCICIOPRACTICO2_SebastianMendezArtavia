package CasoEstudio2.Caso2.service.impl;


import CasoEstudio2.Caso2.Dao.ReservaDao;
import CasoEstudio2.Caso2.domain.Reserva;
import CasoEstudio2.Caso2.domain.Usuario;
import CasoEstudio2.Caso2.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;

    @Override
    public List<Reserva> listarReservas() {
        return reservaDao.findAll();
    }

    @Override
    public List<Reserva> listarReservasPorUsuario(Usuario usuario) {
        return reservaDao.findByUsuario(usuario);
    }

    @Override
    public void guardar(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    public void eliminar(Reserva reserva) {
        reservaDao.delete(reserva);
    }

    @Override
    public Reserva encontrarReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getId()).orElse(null);
    }
}