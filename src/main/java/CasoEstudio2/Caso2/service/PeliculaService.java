package CasoEstudio2.Caso2.service;


import CasoEstudio2.Caso2.domain.Pelicula;
import java.util.List;

public interface PeliculaService {
    
    public List<Pelicula> listarPeliculas();
    
    public void guardar(Pelicula pelicula);
    
    public void eliminar(Pelicula pelicula);
    
    public Pelicula encontrarPelicula(Pelicula pelicula);
}
