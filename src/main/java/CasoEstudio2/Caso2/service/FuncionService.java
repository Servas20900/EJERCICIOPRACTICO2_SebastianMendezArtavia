package CasoEstudio2.Caso2.service;


import CasoEstudio2.Caso2.domain.Funcion;
import java.util.List;

public interface FuncionService {

    List<Funcion> listarFunciones();

    Funcion encontrarFuncion(Funcion funcion);

    void guardar(Funcion funcion);
    
    void eliminar(Funcion funcion);
}
