package com.example.apicrud.controllers;

import com.example.apicrud.entities.CarEntity;
import com.example.apicrud.repositories.CarRepository;
import com.example.apicrud.response.CommonResponse;
import com.example.apicrud.response.CommonResponseGenerator;
import com.example.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @Autowired
    CarService carService;

    private CarEntity car;
    private List<CarEntity> carList;

    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkApi(){
        try {
            return commonResponseGenerator.successResponse("Hello World","Success Check API");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param){
        try {
            car = carService.addCar(param);
            return commonResponseGenerator.successResponse(car,"Success add new data");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar(){
        try {
            carList = carService.getAll();
            return commonResponseGenerator.successResponse(carList,"Success get all data");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id){
        try {
            car = carService.getById(id);
            return commonResponseGenerator.successResponse(car,"Success get data by id");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "updateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param){
        try {
            car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car, "Success update data");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage()+" for id : "+param.getId());
        }
    }

    @GetMapping(value = "justDeleteCar")
    public CommonResponse<String> justDeleteCar(@RequestParam int id){
        try {
            carService.deleteCar(id);
            return commonResponseGenerator.successResponse(id,"Success deleted car");
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage()+" for id : "+id);
        }
    }

    @GetMapping(value = "deleteCar")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id){
        try {
            carService.deleteCar(id);
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }

        try {
            carList = carService.getAll();
            return commonResponseGenerator.successResponse(carList,"Data has been deleted id : "+id);
        } catch (Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}