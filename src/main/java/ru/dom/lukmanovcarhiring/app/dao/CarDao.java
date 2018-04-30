package ru.dom.lukmanovcarhiring.app.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarEntity;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarHiringStatus;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.params.CarParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;

@Repository(value = CarDao.DAO_NAME)
public class CarDao extends CommonHibernateDAO<CarParams, CarEntity, CarDto> {

    public static final String DAO_NAME = "carDao";

    @Override
    protected void addRestrictions(Criteria criteria, CarParams params) {
        super.addRestrictions(criteria, params);
    }

    @Override
    @Transactional
    public CarDto updateStatus(Long id) {
        Session session = this.getSessionFactory().getCurrentSession();
        CarEntity carEntity = (CarEntity) session.get(CarEntity.class, id);
        carEntity.setStatus(CarHiringStatus.IS_NOT_AVAILABLE);
        return this.modelMapper.map(carEntity, CarDto.class);
    }
}
