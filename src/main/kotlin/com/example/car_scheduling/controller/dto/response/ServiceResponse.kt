package com.example.car_scheduling.controller.dto.response

import com.example.car_scheduling.model.EmployeeModel
import com.example.car_scheduling.model.WorkOrderModel

data class ServiceResponse (

    val nameService: String,

    val descriptionService: String,

    val priceService: Float,

    val estimatedTimeService: String,

    val idEmployee: List<EmployeeModel>,

    val workOrders: List<WorkOrderModel>?

)
