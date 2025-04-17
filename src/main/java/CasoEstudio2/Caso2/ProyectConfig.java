package CasoEstudio2.Caso2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class ProyectConfig {

    private final UserDetailsService userDetailsService;

    public ProyectConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Bean para codificar contraseñas usando BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean para el AuthenticationManager que usa el userDetailsService y el passwordEncoder
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // Configuración de seguridad para las rutas y acceso
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                // Permite acceso a las rutas públicas (login, recursos estáticos)
                .requestMatchers("/", "/login", "/css/**", "/img/**", "/js/**").permitAll()
                // Se requiere autenticación para las páginas de administración de películas y funciones
                .requestMatchers("/private/admin/peliculas/**", "/private/admin/funcion/**").authenticated()
                // Cualquier otra ruta también requiere autenticación
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                // Página de login personalizada
                .loginPage("/login")
                // Redirige al home privado después del login exitoso
                .defaultSuccessUrl("/private/home", true)
                .permitAll()
            )
            .logout((logout) -> logout
                // Redirige al login después de hacer logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
