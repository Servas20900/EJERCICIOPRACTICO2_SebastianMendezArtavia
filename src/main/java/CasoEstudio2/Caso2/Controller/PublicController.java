package CasoEstudio2.Caso2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/") // Página principal
    public String mostrarIndex() {
        return "public/index"; // Esto buscará index.html en templates/
    }
}