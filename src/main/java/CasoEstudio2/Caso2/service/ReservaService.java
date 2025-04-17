package CasoEstudio2.Caso2.service;

import CasoEstudio2.Caso2.domain.Reserva;
import CasoEstudio2.Caso2.domain.Usuario;
import java.util.List;

public interface ReservaService {
    public List<Reserva> listarReservas();
    public List<Reserva> listarReservasPorUsuario(Usuario usuario);
    public void guardar(Reserva reserva);
    public void eliminar(Reserva reserva);
    public Reserva encontrarReserva(Reserva reserva);
}