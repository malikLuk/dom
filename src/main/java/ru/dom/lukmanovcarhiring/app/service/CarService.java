package ru.dom.lukmanovcarhiring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.dom.lukmanovcarhiring.app.dao.CarDao;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarEntity;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.params.CarParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

@Service
public class CarService extends CommonService<CarParams, CarEntity, CarDto> {

    @Autowired
    private final CommonHibernateDAO<CarParams, CarEntity, CarDto> dao;

    public CarService(@Qualifier(CarDao.DAO_NAME) CommonHibernateDAO<CarParams, CarEntity, CarDto> dao) {
        this.dao = dao;
    }

    @Override
    public CommonHibernateDAO<CarParams, CarEntity, CarDto> getDao() {
        return dao;
    }

}
