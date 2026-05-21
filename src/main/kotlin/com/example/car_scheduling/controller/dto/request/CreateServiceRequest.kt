package com.example.car_scheduling.controller.dto.request

import com.example.car_scheduling.model.EmployeeModel
import com.example.car_scheduling.model.WorkOrderModel
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateServiceRequest (

    @field: NotBlank
    val name_service: String,

    @field: NotBlank
    val description_service: String,

    @field: NotNull
    val price_service: Float,

    @field: NotBlank
    val estimated_time_service: String,

    @field: NotNull
    val id_employee: List<Int>,

    @field: NotNull
    val work_orders: List<Int>?

)
