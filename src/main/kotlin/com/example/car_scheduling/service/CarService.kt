package com.example.car_scheduling.service

import com.example.car_scheduling.controller.dto.request.CreateCarRequest
import com.example.car_scheduling.enums.Errors
import com.example.car_scheduling.exception.NotFoundException
import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import com.example.car_scheduling.repository.CarRepository
import org.springframework.stereotype.Service

@Service
class CarService (

    val repository: CarRepository
){

    fun createCar(car: CarModel) {
        repository.save(car)
    }

    fun deleteCarById(id: Int) {
        repository.deleteById(id)
    }

    fun updateCarById(car: CarModel) {
        repository.save(car)
    }

    fun getAllCars(): List<CarModel> {
        return repository.findAll()
    }

    fun getCarByid(id: Int): CarModel {
        return repository.findById(id).orElseThrow{ (NotFoundException(Errors.ML201.message.format(id), Errors.ML201.errorCode)) }
    }

    fun existsByPlateCar(plateCar: String): Boolean{
        return !repository.existsByPlateCar(plateCar)
    }
}