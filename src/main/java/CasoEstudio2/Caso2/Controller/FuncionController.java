package CasoEstudio2.Caso2.Controller;

import CasoEstudio2.Caso2.domain.Funcion;
import CasoEstudio2.Caso2.service.FuncionService;
import CasoEstudio2.Caso2.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcion")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/listado")
    public String listarFunciones(Model model) {
        model.addAttribute("funciones", funcionService.listarFunciones());
        return "private/funcion/listado";
    }

    @GetMapping("/nuevo")
    public String nuevaFuncion(Model model) {
        model.addAttribute("funcion", new Funcion());
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "private/funcion/formulario";
    }

    @PostMapping("/guardar")
    public String guardarFuncion(@ModelAttribute Funcion funcion) {
        funcionService.guardar(funcion);
        return "redirect:/funcion/listado";
    }

    @GetMapping("/editar/{id}")
    public String editarFuncion(@PathVariable("id") Long id, Model model) {
        Funcion funcion = new Funcion();
        funcion.setId(id);
        Funcion funcionEncontrada = funcionService.encontrarFuncion(funcion);
        model.addAttribute("funcion", funcionEncontrada);
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "private/funcion/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFuncion(@PathVariable("id") Long id) {
        Funcion funcion = new Funcion();
        funcion.setId(id);
        funcionService.eliminar(funcion);
        return "redirect:/funcion/listado";
    }
}
