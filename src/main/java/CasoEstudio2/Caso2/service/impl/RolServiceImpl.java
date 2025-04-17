package CasoEstudio2.Caso2.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CasoEstudio2.Caso2.Dao.RolDao;
import CasoEstudio2.Caso2.domain.Rol;
import CasoEstudio2.Caso2.service.RolService;


@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;

    @Override
    public List<Rol> getRoles() {
        return rolDao.findAll();
    }

    @Override
    public Rol getRol(Rol rol) {
        return rolDao.findById(rol.getIdRol()).orElse(null);
    }

    @Override
    public void save(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }
}
