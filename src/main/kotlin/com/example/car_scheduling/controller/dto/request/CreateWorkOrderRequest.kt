package com.example.car_scheduling.controller.dto.request

import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class CreateWorkOrderRequest (

    var startDateWorkOrder: LocalDateTime?,

    @field: NotNull
    var idCar: Int,

    @field: NotNull
    var idService: List<Int>,

    @field: NotNull
    var idCustomer: Int,
)
