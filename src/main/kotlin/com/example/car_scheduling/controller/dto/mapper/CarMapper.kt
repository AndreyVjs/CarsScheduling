package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateCarRequest
import com.example.car_scheduling.controller.dto.response.CarResponse
import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.service.CustomerService
import org.springframework.stereotype.Component

@Component
class CarMapper (

    val customerService: CustomerService
){

    fun toModel(request: CreateCarRequest): CarModel {

        return CarModel(
            nameCar = request.nameCar,
            colorCar = request.colorCar,
            markCar = request.markCar,
            plateCar = request.plateCar,
            idCustomer = customerService.getCustomerById(request.idCustomer)
        )
    }

    fun toModelById(id: Int, request: CreateCarRequest): CarModel {

        return CarModel(
            nameCar = request.nameCar,
            colorCar = request.colorCar,
            markCar = request.markCar,
            plateCar = request.plateCar,
            idCustomer = customerService.getCustomerById(id)
        )
    }

    fun toCarsResponse(cars :List<CarModel>): List<CarResponse> {

        return cars.map {

            CarResponse(

                nameCar = it.nameCar,
                colorCar = it.colorCar,
                markCar = it.markCar,
                plateCar = it.plateCar
            )
        }
    }

    fun toCarResponse(car : CarModel): CarResponse {

        return CarResponse(

            nameCar = car.nameCar,
            colorCar = car.colorCar,
            markCar = car.markCar,
            plateCar = car.plateCar
        )
    }
}