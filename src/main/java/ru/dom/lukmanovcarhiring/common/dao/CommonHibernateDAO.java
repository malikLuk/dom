package ru.dom.lukmanovcarhiring.common.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.common.dao.entity.CommonEntity;
import ru.dom.lukmanovcarhiring.common.dto.CommonDto;

import java.util.List;
import java.util.stream.Collectors;

public class CommonHibernateDAO<P extends CommonParams, E extends CommonEntity, D extends CommonDto> {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ModelMapper modelMapper;
    
    private Class<P> paramsClass;

    private Class<E> entityClass;

    private Class<D> dtoClass;

    public Class<E> getEntityClass() {
        return entityClass;
    }

    public Class<D> getDtoClass() { return dtoClass; }

    public Class<P> getParamsClass() {
        return paramsClass;
    }

    protected Criteria getCriteria() {
        return this.sessionFactory.getCurrentSession().createCriteria(this.getEntityClass());
    }

    public CommonHibernateDAO() {
        final Class<?>[] resolveTypeArguments = GenericTypeResolver.resolveTypeArguments(getClass(), CommonHibernateDAO.class);
        this.paramsClass = (Class<P>) resolveTypeArguments[0];
        this.entityClass = (Class<E>) resolveTypeArguments[1];
        this.dtoClass = (Class<D>) resolveTypeArguments[2];
    }

    @Transactional
    public List<D> listAll(P params) {
        Criteria criteria = this.getCriteria();
        addRestrictions(criteria, params);
        List<D> dtoList = (List<D>) criteria.list()
            .stream().map(entity -> modelMapper.map(entity, dtoClass))
            .collect(Collectors.toList());
        return dtoList;
    }

    protected void addRestrictions(Criteria criteria, CommonParams params) {

    }

}
