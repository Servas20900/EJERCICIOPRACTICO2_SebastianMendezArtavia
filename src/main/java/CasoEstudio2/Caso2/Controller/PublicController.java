package CasoEstudio2.Caso2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/") 
    public String mostrarIndex() {
        return "public/index"; 
    }
}