package com.example.apicrud.services.impl;

import com.example.apicrud.entities.CarEntity;
import com.example.apicrud.repositories.CarRepository;
import com.example.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntity addCar(CarEntity param) {
        return carRepository.save(param);
    }

    @Override
    public List<CarEntity> getAll() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param) {
        CarEntity findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setType(param.getType());
        findCar.setNumber(param.getNumber());
        findCar.setColor(param.getColor());
        return carRepository.save(findCar);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
