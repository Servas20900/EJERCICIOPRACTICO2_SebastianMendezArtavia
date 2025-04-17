package CasoEstudio2.Caso2.service.impl;


import CasoEstudio2.Caso2.Dao.PeliculaDao;
import CasoEstudio2.Caso2.domain.Pelicula;
import CasoEstudio2.Caso2.service.PeliculaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaDao.findAll();
    }

    @Override
    public void guardar(Pelicula pelicula) {
        peliculaDao.save(pelicula);
    }

    @Override
    public void eliminar(Pelicula pelicula) {
        peliculaDao.delete(pelicula);
    }

    @Override
    public Pelicula encontrarPelicula(Pelicula pelicula) {
        Optional<Pelicula> resultado = peliculaDao.findById(pelicula.getId());
        return resultado.orElse(null);
    }
}