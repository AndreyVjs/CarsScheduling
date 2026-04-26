package com.example.car_scheduling.controller.dto.request

import com.example.car_scheduling.enum.StatusWorkOrder
import java.time.LocalDateTime

data class CreateWorkOrderRequest (

    var start_date_work_order: LocalDateTime?,
    var id_car: Int,
    var id_service: List<Int>,
    var id_customer: Int,
)
