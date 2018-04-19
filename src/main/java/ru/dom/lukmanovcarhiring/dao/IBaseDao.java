package ru.dom.lukmanovcarhiring.dao;

import ru.dom.lukmanovcarhiring.dao.entity.CarsEntity;

import java.util.List;

public interface IBaseDao {

    public List<CarsEntity> getAllCars();

}
