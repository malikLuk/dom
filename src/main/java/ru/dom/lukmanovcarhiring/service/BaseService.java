package ru.dom.lukmanovcarhiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dom.lukmanovcarhiring.dao.BaseDao;
import ru.dom.lukmanovcarhiring.model.Cars;

import java.util.List;

@Service("baseService")
public class BaseService {

    @Autowired
    private BaseDao baseDao;

    @Transactional
    public List<Cars> getAllCars() {
        return baseDao.listAll();
    }

}
