package CasoEstudio2.Caso2.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CasoEstudio2.Caso2.Dao.RutaPermitDao;
import CasoEstudio2.Caso2.domain.RutaPermit;
import CasoEstudio2.Caso2.service.RutaPermitService;


@Service
public class RutaPermitServiceImpl implements RutaPermitService {

    @Autowired
    private RutaPermitDao rutaPermitDao;

    @Override
    public List<RutaPermit> getRutaPermits() {
        return rutaPermitDao.findAll();
    }

    @Override
    public RutaPermit getRutaPermit(RutaPermit rutaPermit) {
        return rutaPermitDao.findById(rutaPermit.getIdRuta()).orElse(null);
    }

    @Override
    public void save(RutaPermit rutaPermit) {
        rutaPermitDao.save(rutaPermit);
    }

    @Override
    public void delete(RutaPermit rutaPermit) {
        rutaPermitDao.delete(rutaPermit);
    }
}
