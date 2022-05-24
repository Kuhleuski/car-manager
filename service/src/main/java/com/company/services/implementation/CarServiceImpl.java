package com.company.services.implementation;

import com.company.dao.implementation.CarDaoImpl;
import com.company.dao.interfaces.CarDao;
import com.company.dto.CarDto;
import com.company.dto.mapper.CarMapper;
import com.company.entity.Car;
import com.company.services.interfaces.CarService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    CarDao carDao = new CarDaoImpl();
    @Override
    public List<CarDto> findAllCars() {
        return carDao.findAll()
                .stream()
                .map(CarMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public String updateCar(Integer id, String name) throws SQLException {
        Car car = carDao.findOne(id);
        car.setName(name);
        Car update = carDao.update(car);
        if (car.equals(update)) {
            return "STUDENT SUCCESSFULLY UPDATE";
        } else {
            return "UPDATE ERROR";
        }
    }
}
