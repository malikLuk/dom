package ru.dom.lukmanovcarhiring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.common.params.CommonParams;
import ru.dom.lukmanovcarhiring.app.dao.BaseDao;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;

import java.util.List;

@Service("baseService")
public class BaseService<P extends CommonParams> {

    @Autowired
    private BaseDao baseDao;

    @Transactional
    public List<CarDto> filter(P params) {
        return baseDao.listAll(params);
    }

}
