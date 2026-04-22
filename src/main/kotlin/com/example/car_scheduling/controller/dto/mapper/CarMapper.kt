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
            name_car = request.name_car,
            color = request.color,
            mark_car = request.mark_car,
            plate_car = request.plate_car,
            customer_id = customerService.getCustomerById(request.customer_id)
        )
    }

    fun toModelById(id: Int, request: CreateCarRequest): CarModel {

        return CarModel(
        name_car = request.name_car,
        color = request.color,
        mark_car = request.mark_car,
        plate_car = request.plate_car,
        customer_id = customerService.getCustomerById(id)
        )
    }

    fun toCarsResponse(cars :List<CarModel>): List<CarResponse> {

        return cars.map {

            CarResponse(

                name_car = it.name_car,
                color = it.color,
                mark_car = it.mark_car,
                plate_car = it.plate_car
            )
        }
    }

    fun toCarResponse(car : CarModel): CarResponse {

        return CarResponse(

            name_car = car.name_car,
            color = car.color,
            mark_car = car.mark_car,
            plate_car = car.plate_car
        )
    }
}