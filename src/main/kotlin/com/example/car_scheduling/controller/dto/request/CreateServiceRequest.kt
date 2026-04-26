package com.example.car_scheduling.controller.dto.request

import com.example.car_scheduling.model.EmployeeModel
import com.example.car_scheduling.model.WorkOrderModel
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne

data class CreateServiceRequest (

    val name_service: String,

    val description_service: String,

    val price_service: Float,

    val estimated_time_service: String,

    val id_employee: List<Int>,

    val work_orders: List<Int>?

)
