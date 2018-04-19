package ru.dom.lukmanovcarhiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.common.dao.CommonParams;
import ru.dom.lukmanovcarhiring.dao.BaseDao;
import ru.dom.lukmanovcarhiring.dao.entity.CarsEntity;
import ru.dom.lukmanovcarhiring.dto.CarsDto;

import java.util.List;

@Service("baseService")
public class BaseService<P extends CommonParams> {

    @Autowired
    private BaseDao baseDao;

    @Transactional
    public List<CarsDto> getAllCars(P params) {
        return baseDao.listAll(params);
    }

}
