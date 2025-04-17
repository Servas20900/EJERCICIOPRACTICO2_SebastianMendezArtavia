package CasoEstudio2.Caso2.Controller;

import CasoEstudio2.Caso2.domain.Pelicula;
import CasoEstudio2.Caso2.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    // Método para listar las películas
    @GetMapping
    public String listarPeliculas(Model model) {
        var peliculas = peliculaService.listarPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "private/admin/listado";  // Vista actualizada
    }

    // Método para mostrar el formulario para agregar una nueva película
    @GetMapping("/nueva")
    public String nuevaPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "private/admin/formulario";  // Vista actualizada
    }

    // Método para guardar una nueva película
    @PostMapping("/guardar")
    public String guardar(Pelicula pelicula, BindingResult result) {
        if (result.hasErrors()) {
            return "private/admin/formulario";  // Vista actualizada
        }
        peliculaService.guardar(pelicula);
        return "redirect:/admin/peliculas";  // Redirige a la lista de películas
    }

    // Método para editar una película existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(id);
        pelicula = peliculaService.encontrarPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        return "private/admin/formulario-pelicula";  // Vista actualizada
    }

    // Método para eliminar una película
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(id);
        peliculaService.eliminar(pelicula);
        return "redirect:/admin/peliculas";  // Redirige a la lista de películas
    }
}
