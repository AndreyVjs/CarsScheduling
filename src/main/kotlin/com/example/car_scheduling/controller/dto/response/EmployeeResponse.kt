package com.example.car_scheduling.controller.dto.response

import java.time.LocalDate
import java.util.Date

data class EmployeeResponse (

    val nameEmployee: String,
    val telefoneEmployee: String,
    val emailEmployee: String,
    val salaryEmployee: Float,
    val birthdayEmployee: LocalDate,
    val roleEmployee: String
)
