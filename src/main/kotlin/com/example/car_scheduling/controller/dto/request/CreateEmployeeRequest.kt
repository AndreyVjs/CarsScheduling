package com.example.car_scheduling.controller.dto.request

import jakarta.persistence.Column
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

data class CreateEmployeeRequest (

    val name_employee: String,
    val telefone_employee: String,
    val email_employee: String,
    val salary_employee: Float,
    val birthday_employee: LocalDate,
    val role_employee: String
)
