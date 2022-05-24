package com.company.services.interfaces;

import com.company.dao.interfaces.CarDao;

public interface GeneralService {

    Integer getIdCar(String name, CarDao carDao);
}
