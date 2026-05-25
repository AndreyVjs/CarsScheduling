package com.example.car_scheduling.controller.dto.request

import com.example.car_scheduling.validation.EmailAvaliable
import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

data class CreateEmployeeRequest (

    @field: NotBlank
    val nameEmployee: String,

    @field: NotBlank
    val telefoneEmployee: String,

    @EmailAvaliable
    val emailEmployee: String,

    @field: NotNull
    val salaryEmployee: Float,

    @field: NotNull
    val birthdayEmployee: LocalDate,

    @field:NotBlank
    val roleEmployee: String
)
