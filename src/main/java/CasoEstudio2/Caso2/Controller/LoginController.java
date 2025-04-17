package CasoEstudio2.Caso2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login") 
    public String mostrarHome() {
        return "public/login";
    }
}