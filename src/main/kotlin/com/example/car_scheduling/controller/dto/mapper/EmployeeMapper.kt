package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateEmployeeRequest
import com.example.car_scheduling.controller.dto.response.EmployeeResponse
import com.example.car_scheduling.model.EmployeeModel
import org.springframework.stereotype.Component

@Component
class EmployeeMapper {

    fun toModel(request: CreateEmployeeRequest): EmployeeModel {

        return EmployeeModel(

            name_employee = request.name_employee,
            telefone_employee = request.telefone_employee,
            email_employee = request.email_employee,
            salary_employee = request.salary_employee,
            birthday_employee = request.birthday_employee,
            role_employee = request.role_employee
        )
    }

    fun toModelById(request: CreateEmployeeRequest, id: Int): EmployeeModel {

        return EmployeeModel(

            id_employee = id,
            name_employee = request.name_employee,
            telefone_employee = request.telefone_employee,
            email_employee = request.email_employee,
            salary_employee = request.salary_employee,
            birthday_employee = request.birthday_employee,
            role_employee = request.role_employee
        )
    }

    fun toResponse(model: List<EmployeeModel>): List<EmployeeResponse> {

        return model.map{

            EmployeeResponse(

                name_employee = it.name_employee,
                telefone_employee = it.telefone_employee,
                email_employee = it.email_employee,
                salary_employee = it.salary_employee,
                birthday_employee = it.birthday_employee,
                role_employee = it.role_employee
            )
        }
    }

    fun toResponseById(model: EmployeeModel): EmployeeResponse {

        return EmployeeResponse(
            name_employee = model.name_employee,
            telefone_employee = model.telefone_employee,
            email_employee = model.email_employee,
            salary_employee = model.salary_employee,
            birthday_employee = model.birthday_employee,
            role_employee = model.role_employee

        )
    }
}