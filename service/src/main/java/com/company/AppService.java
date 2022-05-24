package com.company;

import com.company.dto.CarDto;
import com.company.services.implementation.AdminServiceImpl;
import com.company.services.implementation.CarServiceImpl;
import com.company.services.interfaces.AdminService;
import com.company.services.interfaces.CarService;

import java.sql.SQLException;
import java.util.List;

public class AppService {
    public static void main(String[] args) {

        AdminService adminService = new AdminServiceImpl();
        CarService carService = new CarServiceImpl();

        adminService.createCar("MERS");
        adminService.createCar("BMW");

        List<CarDto> cars = getAllCarsFromDb(carService);
        for (CarDto x : cars) {
            System.out.println(x.getName());
        }

        try {

            String result = carService.updateCar(2, "Volvo");
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("========");
        List<CarDto> cars2 = getAllCarsFromDb(carService);
        for (CarDto x : cars2) {
            System.out.println(x.getName());
        }

        try {
            adminService.deleteCar("MERS");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("========");
        List<CarDto> cars3 = getAllCarsFromDb(carService);
        for (CarDto x : cars3) {
            System.out.println(x.getName() + ", [" + x.getId() + "]");
        }
    }

    private static List<CarDto> getAllCarsFromDb(CarService carService) {
        return carService.findAllCars();
    }
}
