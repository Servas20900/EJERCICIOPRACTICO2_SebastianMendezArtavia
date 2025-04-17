package CasoEstudio2.Caso2.service;

import java.util.List;
import CasoEstudio2.Caso2.domain.Ruta;

public interface RutaService {

    public List<Ruta> getRutas();

    public Ruta getRuta(Ruta ruta);

    public void save(Ruta ruta);

    public void delete(Ruta ruta);
}
