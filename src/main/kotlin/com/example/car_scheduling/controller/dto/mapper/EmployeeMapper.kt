package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateEmployeeRequest
import com.example.car_scheduling.controller.dto.response.EmployeeResponse
import com.example.car_scheduling.model.EmployeeModel
import org.springframework.stereotype.Component

@Component
class EmployeeMapper {

    fun toModel(request: CreateEmployeeRequest): EmployeeModel {

        return EmployeeModel(

            nameEmployee = request.nameEmployee,
            telefoneEmployee = request.telefoneEmployee,
            emailEmployee = request.emailEmployee,
            salaryEmployee = request.salaryEmployee,
            birthdayEmployee = request.birthdayEmployee,
            roleEmployee = request.roleEmployee
        )
    }

    fun toModelById(request: CreateEmployeeRequest, id: Int): EmployeeModel {

        return EmployeeModel(

            idEmployee = id,
            nameEmployee = request.nameEmployee,
            telefoneEmployee = request.telefoneEmployee,
            emailEmployee = request.emailEmployee,
            salaryEmployee = request.salaryEmployee,
            birthdayEmployee = request.birthdayEmployee,
            roleEmployee = request.roleEmployee
        )
    }

    fun toResponse(model: List<EmployeeModel>): List<EmployeeResponse> {

        return model.map{

            EmployeeResponse(

                nameEmployee = it.nameEmployee,
                telefoneEmployee = it.telefoneEmployee,
                emailEmployee = it.emailEmployee,
                salaryEmployee = it.salaryEmployee,
                birthdayEmployee = it.birthdayEmployee,
                roleEmployee = it.roleEmployee
            )
        }
    }

    fun toResponseById(model: EmployeeModel): EmployeeResponse {

        return EmployeeResponse(
            nameEmployee = model.nameEmployee,
            telefoneEmployee = model.telefoneEmployee,
            emailEmployee = model.emailEmployee,
            salaryEmployee = model.salaryEmployee,
            birthdayEmployee = model.birthdayEmployee,
            roleEmployee = model.roleEmployee

        )
    }
}