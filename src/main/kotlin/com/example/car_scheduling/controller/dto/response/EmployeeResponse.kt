package com.example.car_scheduling.controller.dto.response

import java.time.LocalDate
import java.util.Date

data class EmployeeResponse (

    val name_employee: String,
    val telefone_employee: String,
    val email_employee: String,
    val salary_employee: Float,
    val birthday_employee: LocalDate,
    val role_employee: String
)
