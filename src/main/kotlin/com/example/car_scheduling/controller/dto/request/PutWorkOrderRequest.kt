package com.example.car_scheduling.controller.dto.request

import com.example.car_scheduling.enums.StatusWorkOrder
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class PutWorkOrderRequest (

    @field:NotNull
    val statusWorkOrder: StatusWorkOrder,

    var idCar: Int?,

    var idService: List<Int>?,

    var idCustomer: Int?,
)