package CasoEstudio2.Caso2.Dao;


import org.springframework.data.repository.CrudRepository;
import CasoEstudio2.Caso2.domain.Funcion;

public interface FuncionDao extends CrudRepository<Funcion, Long> {
}