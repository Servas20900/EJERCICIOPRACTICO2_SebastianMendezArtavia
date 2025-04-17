package CasoEstudio2.Caso2.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {
    UserDetails loadUserByNombre(String nombre) throws UsernameNotFoundException;
}