package com.company.dto.mapper;

import com.company.dto.CarDto;
import com.company.entity.Car;

public class CarMapper {
    public static CarDto mapFrom(Car car) {
        return new CarDto(car.getId(), car.getName());
    }
}
