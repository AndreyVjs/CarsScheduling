package com.example.car_scheduling.controller.dto.response

import com.example.car_scheduling.enums.StatusWorkOrder
import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import java.time.LocalDateTime

data class WorkOrderResponse (

    val start_date_work_order: LocalDateTime,
    val end_date_work_order: LocalDateTime,
    val status_work_order: StatusWorkOrder,
    val customer: CustomerModel,
    val car: CarModel
)
