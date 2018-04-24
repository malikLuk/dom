package ru.dom.lukmanovcarhiring.app.dao;

import org.springframework.stereotype.Repository;
import ru.dom.lukmanovcarhiring.app.dao.entity.LocationEntity;
import ru.dom.lukmanovcarhiring.app.dto.LocationDto;
import ru.dom.lukmanovcarhiring.app.params.LocationParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;

@Repository("locationDao")
public class LocationDao extends CommonHibernateDAO<LocationParams, LocationEntity, LocationDto> {
}
