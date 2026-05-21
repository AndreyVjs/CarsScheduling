package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateCustomerRequest
import com.example.car_scheduling.controller.dto.response.CarResponse
import com.example.car_scheduling.controller.dto.response.GetCustomerResponse
import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import org.springframework.stereotype.Component

@Component
class CustomerMapper {

    fun toModel (request: CreateCustomerRequest): CustomerModel {
        return CustomerModel(
            name_customer = request.name_customer,
            telefone_customer = request.telefone_customer!!,
            email_customer = request.email_customer
        )
    }

    fun toModelById (request: CreateCustomerRequest, id: Int): CustomerModel {
        return CustomerModel(
            id_customer = id,
            name_customer = request.name_customer,
            telefone_customer = request.telefone_customer!!,
            email_customer = request.email_customer
        )
    }

    fun toResponse(model: CustomerModel): GetCustomerResponse {
        return GetCustomerResponse(
            name_customer = model.name_customer,
            email_customer = model.email_customer,
            telefone_customer = model.telefone_customer
        )
    }

    fun toAllResponse(customer: List<CustomerModel>): List<GetCustomerResponse> {

        return customer.map {

            GetCustomerResponse(
                name_customer = it.name_customer,
                email_customer = it.email_customer,
                telefone_customer = it.telefone_customer
            )
        }
    }

    fun toCarsResponse(cars :List<CarModel>): List<CarResponse> {

        return cars.map {

            CarResponse(

                name_car = it.name_car,
                color = it.color,
                mark_car = it.mark_car,
                plate_car = it.plate_car
            )
        }
    }

}