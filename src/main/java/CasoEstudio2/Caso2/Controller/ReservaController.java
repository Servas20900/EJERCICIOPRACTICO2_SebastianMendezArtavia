package CasoEstudio2.Caso2.Controller;


import CasoEstudio2.Caso2.domain.Funcion;
import CasoEstudio2.Caso2.domain.Reserva;
import CasoEstudio2.Caso2.domain.Usuario;
import CasoEstudio2.Caso2.service.FuncionService;
import CasoEstudio2.Caso2.service.ReservaService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private FuncionService funcionService;

    @GetMapping("/mis-reservas")
    public String listarMisReservas(Model model, Principal principal) {
        Usuario usuario = new Usuario();
        usuario.setUsername(principal.getName());
        model.addAttribute("reservas", reservaService.listarReservasPorUsuario(usuario));
        return "private/usuario/mis-reservas";
    }

    @GetMapping("/nueva/{idFuncion}")
    public String nuevaReserva(@PathVariable("idFuncion") Long idFuncion, Model model) {
        Funcion funcion = new Funcion();
        funcion.setId(idFuncion);
        Reserva reserva = new Reserva();
        reserva.setFuncion(funcion);
        model.addAttribute("reserva", reserva);
        return "private/usuario/formulario-reserva";
    }

    @PostMapping("/guardar")
    public String guardarReserva(Reserva reserva, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "private/usuario/formulario-reserva";
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(principal.getName());
        reserva.setUsuario(usuario);
        reservaService.guardar(reserva);
        return "redirect:/reservas/mis-reservas";
    }
}
