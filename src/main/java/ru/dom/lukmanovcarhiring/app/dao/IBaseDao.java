package ru.dom.lukmanovcarhiring.app.dao;

import ru.dom.lukmanovcarhiring.app.dao.entity.CarsEntity;

import java.util.List;

public interface IBaseDao {

    public List<CarsEntity> getAllCars();

}
