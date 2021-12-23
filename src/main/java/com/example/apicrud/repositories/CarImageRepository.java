package com.example.apicrud.repositories;

import com.example.apicrud.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
}
