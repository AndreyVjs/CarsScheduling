package com.example.car_scheduling.controller.dto.request

data class CreateCarRequest (

    val name_car: String,
    val color: String,
    val mark_car: String,
    val plate_car: String,
    val customer_id: Int
)
