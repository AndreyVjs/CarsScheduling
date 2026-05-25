package com.example.car_scheduling.repository

import com.example.car_scheduling.model.CarModel
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository: JpaRepository<CarModel, Int> {
    fun existsByPlateCar(plateCar: String): Boolean
}