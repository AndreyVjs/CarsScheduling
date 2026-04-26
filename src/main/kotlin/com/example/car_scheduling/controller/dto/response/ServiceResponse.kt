package com.example.car_scheduling.controller.dto.response

import com.example.car_scheduling.model.EmployeeModel
import com.example.car_scheduling.model.WorkOrderModel

data class ServiceResponse (

    val name_service: String,

    val description_service: String,

    val price_service: Float,

    val estimated_time_service: String,

    val id_employee: List<EmployeeModel>,

    val work_orders: List<WorkOrderModel>?

)
