package ru.dom.lukmanovcarhiring.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dom.lukmanovcarhiring.common.dao.CommonHibernateDAO;
import ru.dom.lukmanovcarhiring.common.dao.entity.CommonEntity;
import ru.dom.lukmanovcarhiring.common.params.CommonParams;
import ru.dom.lukmanovcarhiring.common.dto.CommonDto;

import java.util.List;

@Service
public abstract class CommonService<P extends CommonParams, E extends CommonEntity, D extends CommonDto> {

    public abstract CommonHibernateDAO<P, E, D> getDao();

    public List<D> filter(P params) {
        return this.getDao().filter(params);
    }

    public D updateStatus(P params) {
        return this.getDao().updateStatus(params);
    }

}
