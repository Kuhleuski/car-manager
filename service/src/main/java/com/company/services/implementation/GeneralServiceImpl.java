package com.company.services.implementation;

import com.company.dao.interfaces.CarDao;
import com.company.entity.Car;
import com.company.services.interfaces.GeneralService;

public class GeneralServiceImpl implements GeneralService {
    @Override
    public Integer getIdCar(String name, CarDao carDao) {
        return carDao.findAll().stream()
                .filter(st -> name.equals(st.getName()))
                .map(Car::getId)
                .findFirst()
                .orElse(null);
    }
}
