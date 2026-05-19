package com.example.car_scheduling.controller

import com.example.car_scheduling.controller.dto.mapper.CarMapper
import com.example.car_scheduling.controller.dto.request.CreateCarRequest
import com.example.car_scheduling.controller.dto.response.CarResponse
import com.example.car_scheduling.service.CarService
import com.example.car_scheduling.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("car")
@CrossOrigin(origins = ["*"])
class CarController (

    val service: CarService,
    val mapper: CarMapper
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCar(@RequestBody car: CreateCarRequest) {
         service.createCar(mapper.toModel(car))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCarById(

        @PathVariable("id") id: Int
    ) {
        service.deleteCarById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun updateCarById(

        @PathVariable("id") id: Int,
        @RequestBody car: CreateCarRequest
    ) {
        service.updateCarById(mapper.toModelById(id,car))
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllCars(): List<CarResponse> {
        return mapper.toCarsResponse(service.getAllCars())
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCarByid(
        @PathVariable("id") id: Int,
    ): CarResponse {
        return mapper.toCarResponse(service.getCarByid(id))
    }


}