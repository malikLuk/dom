package ru.dom.lukmanovcarhiring.app.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarEntity;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.params.CarParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;

@Repository("carDao")
public class CarDao extends CommonHibernateDAO<CarParams, CarEntity, CarDto> {

    @Override
    protected void addRestrictions(Criteria criteria, CarParams params) {
//        params
        super.addRestrictions(criteria, params);
    }
}
