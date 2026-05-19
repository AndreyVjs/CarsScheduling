package com.example.car_scheduling.service

import com.example.car_scheduling.controller.dto.response.EmployeeResponse
import com.example.car_scheduling.enums.Errors
import com.example.car_scheduling.exception.NotFoundException
import com.example.car_scheduling.model.EmployeeModel
import com.example.car_scheduling.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(

    val repository: EmployeeRepository
) {
    fun createEmployee(model: EmployeeModel) {
        repository.save(model)
    }

    fun deleteEmployeeById(id: Int) {
        repository.deleteById(id)
    }

    fun updateEmployeeById(model: EmployeeModel) {
        repository.save(model)
    }

    fun getAllEmployee(): List<EmployeeModel> {
        return repository.findAll()
    }

    fun getEmployeeById(id: Int): EmployeeModel {
        return repository.findById(id).orElseThrow{ (NotFoundException(Errors.ML301.message.format(id), Errors.ML301.errorCode)) }
    }
}