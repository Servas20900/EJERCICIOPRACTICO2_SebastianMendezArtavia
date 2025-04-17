package CasoEstudio2.Caso2.service;

import java.util.List;
import CasoEstudio2.Caso2.domain.Rol;

public interface RolService {

    public List<Rol> getRoles();

    public Rol getRol(Rol rol);

    public void save(Rol rol);

    public void delete(Rol rol);
}
