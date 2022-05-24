package com.company.services.implementation;


import com.company.dao.implementation.CarDaoImpl;
import com.company.dao.interfaces.CarDao;
import com.company.dto.CarDto;
import com.company.dto.mapper.CarMapper;
import com.company.entity.Car;
import com.company.services.interfaces.AdminService;
import com.company.services.interfaces.GeneralService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {

    private final CarDao carDao = new CarDaoImpl();
    GeneralService generalService = new GeneralServiceImpl();

    @Override
    public void createCar(String name) {
        if (generalService.getIdCar(name, carDao) == null) {
            carDao.create(Car.builder()
                    .name(name)
                    .build());
        }
    }

    @Override
    public void deleteCar(String name) throws SQLException {
        Integer idCar = generalService.getIdCar(name, carDao);
        carDao.deleteById(idCar);
    }

    @Override
    public CarDto findCarById(Integer id) throws SQLException {
        return CarMapper.mapFrom(carDao.findOne(id));
    }

    @Override
    public List<CarDto> getAllCar() {
        return carDao.findAll()
                .stream()
                .map(CarMapper::mapFrom)
                .collect(Collectors.toList());
    }
}
