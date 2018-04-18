package ru.dom.lukmanovcarhiring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dom.lukmanovcarhiring.common.dao.BaseParams;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.model.Cars;

import java.util.List;

@Repository
public class BaseDao extends CommonHibernateDAO<BaseParams, Cars>{

    @Autowired
    private SessionFactory sessionFactory;

    /*public List<Cars> getAllCars() {
        Session session = sessionFactory.getCurrentSession();
        List<Cars> cars = session.createQuery("from Cars").list();
        return cars;
    }*/

}
