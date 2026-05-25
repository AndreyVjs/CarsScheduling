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
    val nameService: String,

    @field: NotBlank
    val descriptionService: String,

    @field: NotNull
    val priceService: Float,

    @field: NotBlank
    val estimatedTimeService: String,

    @field: NotNull
    val idEmployee: List<Int>,

    @field: NotNull
    val workOrders: List<Int>?

)
