package CasoEstudio2.Caso2.Controller;

import CasoEstudio2.Caso2.domain.Funcion;
import CasoEstudio2.Caso2.service.FuncionService;
import CasoEstudio2.Caso2.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/funcion")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listarFunciones(Model model) {
        var funciones = funcionService.listarFunciones();
        model.addAttribute("funciones", funciones);
        return "private/admin/funcion/listado-funciones";
    }

    @GetMapping("/nueva")
    public String nuevaFuncion(Model model) {
        model.addAttribute("funcion", new Funcion());
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "private/admin/funcion/formulario-funcion";
    }

    @PostMapping("/guardar")
    public String guardar(Funcion funcion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("peliculas", peliculaService.listarPeliculas());
            return "private/admin/funcion/formulario-funcion";
        }
        funcionService.guardar(funcion);
        return "redirect:/admin/funcion";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Funcion funcion = new Funcion();
        funcion.setId(id);
        funcion = funcionService.encontrarFuncion(funcion);
        model.addAttribute("funcion", funcion);
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "private/admin/funcion/formulario-funcion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        Funcion funcion = new Funcion();
        funcion.setId(id);
        funcionService.eliminar(funcion);
        return "redirect:/admin/funcion";
    }
}
