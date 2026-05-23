package com.example.car_scheduling.controller.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CreateCarRequest (

    @field:NotBlank
    val name_car: String,

    @field:NotBlank
    val color: String,

    @field:NotBlank
    val mark_car: String,

    //Tem que ter um car avaliable aqui
    @field:NotBlank
    val plate_car: String,

    @field:NotNull
    val customer_id: Int
)
