package com.example.car_scheduling.controller.dto.request

import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

data class CreateEmployeeRequest (

    @field: NotBlank
    val name_employee: String,

    @field: NotBlank
    val telefone_employee: String,

    @field: NotBlank
    val email_employee: String,

    @field: NotNull
    val salary_employee: Float,

    @field: NotNull
    val birthday_employee: LocalDate,

    @field:NotBlank
    val role_employee: String
)
