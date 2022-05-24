package com.company.services.interfaces;

import com.company.dto.CarDto;

import java.sql.SQLException;
import java.util.List;

public interface CarService {

    List<CarDto> findAllCars();

    String updateCar(Integer id, String name) throws SQLException;
}
