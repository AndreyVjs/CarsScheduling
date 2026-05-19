package com.example.car_scheduling.controller.dto.response

import org.springframework.http.HttpStatusCode

data class ErrorResponse(

    val httpStatusCode: Int,
    val message: String,
    val internalCode: String,
    val errors: List<FildErrorResponse>?
)