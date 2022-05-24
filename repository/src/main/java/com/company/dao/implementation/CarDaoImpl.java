package com.company.dao.implementation;

import com.company.dao.interfaces.CarDao;
import com.company.entity.Car;
import com.company.util.HibernateUtil;

public class CarDaoImpl extends GenericDaoImpl<Car> implements CarDao {
    public CarDaoImpl() {
        super(Car.class,
                HibernateUtil.getEntityManager());
    }
}