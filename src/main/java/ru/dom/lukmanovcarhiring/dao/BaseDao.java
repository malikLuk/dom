package ru.dom.lukmanovcarhiring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dom.lukmanovcarhiring.common.dao.CommonParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.dao.entity.CarsEntity;
import ru.dom.lukmanovcarhiring.dto.CarsDto;

@Repository
public class BaseDao extends CommonHibernateDAO<CommonParams, CarsEntity, CarsDto>{

    @Autowired
    private SessionFactory sessionFactory;

    /*public List<CarsEntity> getAllCars() {
        Session session = sessionFactory.getCurrentSession();
        List<CarsEntity> cars = session.createQuery("from CarsEntity").list();
        return cars;
    }*/

}
