package ru.dom.lukmanovcarhiring.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dom.lukmanovcarhiring.common.dao.CommonParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarEntity;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;

@Repository
public class BaseDao extends CommonHibernateDAO<CommonParams, CarEntity, CarDto>{

    @Autowired
    private SessionFactory sessionFactory;

    /*public List<CarEntity> getAllCars() {
        Session session = sessionFactory.getCurrentSession();
        List<CarEntity> cars = session.createQuery("from CarEntity").list();
        return cars;
    }*/

}
