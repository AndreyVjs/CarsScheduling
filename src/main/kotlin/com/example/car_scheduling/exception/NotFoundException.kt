package com.example.car_scheduling.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}