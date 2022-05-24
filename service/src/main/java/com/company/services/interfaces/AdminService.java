package com.company.services.interfaces;

import com.company.dto.CarDto;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {

    void createCar(String name);

    void deleteCar(String name) throws SQLException;

    CarDto findCarById(Integer id) throws SQLException;

    List<CarDto> getAllCar();
}
