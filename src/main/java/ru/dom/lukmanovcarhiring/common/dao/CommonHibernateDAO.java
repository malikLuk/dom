package ru.dom.lukmanovcarhiring.common.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.common.dao.entity.BaseEntity;

import javax.persistence.Entity;
import java.util.List;

public class CommonHibernateDAO<P extends BaseParams, E extends BaseEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<E> entityClass;

    public Class<E> getTargetClass() {
        return entityClass;
    }

    protected Criteria getCriteria() {
        return this.sessionFactory.getCurrentSession().createCriteria(this.getTargetClass());
    }

    public CommonHibernateDAO() {
        final Class<?>[] resolveTypeArguments = GenericTypeResolver.resolveTypeArguments(getClass(), CommonHibernateDAO.class);
        this.entityClass = (Class<E>) resolveTypeArguments[1];
    }

    @Transactional
    public List<E> listAll() {
        Criteria criteria = this.getCriteria();
        /*this.*/
        return (List<E>) criteria.list();
    }

    protected void addRestrictions(Criteria criteria, BaseParams params) {

    }

}
