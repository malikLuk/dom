package ru.dom.lukmanovcarhiring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dom.lukmanovcarhiring.app.dao.entity.LocationEntity;
import ru.dom.lukmanovcarhiring.app.dto.LocationDto;
import ru.dom.lukmanovcarhiring.app.params.LocationParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

@Service
public class LocationService extends CommonService<LocationParams, LocationEntity, LocationDto> {

    @Autowired
    private final CommonHibernateDAO<LocationParams, LocationEntity, LocationDto> dao;

    public LocationService(CommonHibernateDAO<LocationParams, LocationEntity, LocationDto> dao) {
        this.dao = dao;
    }

    @Override
    public CommonHibernateDAO<LocationParams, LocationEntity, LocationDto> getDao() {
        return dao;
    }
}
