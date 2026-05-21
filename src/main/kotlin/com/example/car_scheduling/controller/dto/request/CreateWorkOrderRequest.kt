package com.example.car_scheduling.controller.dto.request

import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class CreateWorkOrderRequest (

    var start_date_work_order: LocalDateTime?,

    @field: NotNull
    var id_car: Int,

    @field: NotNull
    var id_service: List<Int>,

    @field: NotNull
    var id_customer: Int,
)
