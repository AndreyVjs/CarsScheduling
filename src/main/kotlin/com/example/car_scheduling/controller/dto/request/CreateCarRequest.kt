package com.example.car_scheduling.controller.dto.request

import com.example.car_scheduling.validation.PlateAvaliable
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CreateCarRequest (

    @field:NotBlank
    val nameCar: String,

    @field:NotBlank
    val colorCar: String,

    @field:NotBlank
    val markCar: String,

    //Tem que ter um car avaliable aqui

    @PlateAvaliable
    val plateCar: String,

    @field:NotNull
    val idCustomer: Int
)
