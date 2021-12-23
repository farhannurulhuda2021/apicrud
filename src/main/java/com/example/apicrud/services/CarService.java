package com.example.apicrud.services;

import com.example.apicrud.entities.CarEntity;
import com.example.apicrud.entities.CarImage;
import com.example.apicrud.wrappers.CarImageWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {

    CarEntity addCar(CarEntity param);

    List<CarEntity> getAll();

    CarEntity getById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);

    CarImage upload(CarImageWrapper carImageWrapper);
}
