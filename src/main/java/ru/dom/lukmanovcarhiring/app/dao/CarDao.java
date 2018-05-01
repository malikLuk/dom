package ru.dom.lukmanovcarhiring.app.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarEntity;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarHiringStatus;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.params.CarParams;
import ru.dom.lukmanovcarhiring.app.utils.Utilities;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;

@Repository(value = CarDao.DAO_NAME)
public class CarDao extends CommonHibernateDAO<CarParams, CarEntity, CarDto> {

    public static final String DAO_NAME = "carDao";

    @Override
    protected void addRestrictions(Criteria criteria, CarParams params) {
        if (CarHiringStatus.IS_NOT_AVAILABLE == params.getStatus()) {
            params.setCurrentOwnerId(Utilities.getUser().getId());
        }
        super.addRestrictions(criteria, params);
    }

    @Override
    @Transactional
    public CarDto updateStatus(CarParams params) {
        Session session = this.getSessionFactory().getCurrentSession();
        CarEntity carEntity = (CarEntity) session.get(CarEntity.class, params.getId());
        if (params.getStatus() == CarHiringStatus.IS_NOT_AVAILABLE) {
            carEntity.setStatus(CarHiringStatus.IS_NOT_AVAILABLE);
            carEntity.setCurrentOwnerId(Utilities.getUser().getId());
            return this.modelMapper.map(carEntity, CarDto.class);
        } else {
            carEntity.setStatus(CarHiringStatus.IS_AVAILABLE);
            carEntity.setCurrentOwnerId(null);
            carEntity.setCurrentLocationId(params.getCurrentLocationId());
            return this.modelMapper.map(carEntity, CarDto.class);
        }
    }
}
