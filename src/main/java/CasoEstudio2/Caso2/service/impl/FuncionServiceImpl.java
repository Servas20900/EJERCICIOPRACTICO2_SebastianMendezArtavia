package CasoEstudio2.Caso2.service.impl;


import CasoEstudio2.Caso2.Dao.FuncionDao;
import CasoEstudio2.Caso2.domain.Funcion;
import CasoEstudio2.Caso2.service.FuncionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionDao funcionDao;

    @Override
    public List<Funcion> listarFunciones() {
        return (List<Funcion>) funcionDao.findAll();
    }

    @Override
    public Funcion encontrarFuncion(Funcion funcion) {
        return funcionDao.findById(funcion.getId()).orElse(null);
    }

    @Override
    public void guardar(Funcion funcion) {
        funcionDao.save(funcion);
    }

    @Override
    public void eliminar(Funcion funcion) {
        funcionDao.delete(funcion);
    }
}