package com.example.car_scheduling.repository

import com.example.car_scheduling.model.EmployeeModel
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository: JpaRepository<EmployeeModel, Int> {
}