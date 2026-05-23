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
            nameCustomer = request.nameCustomer,
            telefoneCustomer = request.telefoneCustomer!!,
            emailCustomer = request.emailCustomer
        )
    }

    fun toModelById (request: CreateCustomerRequest, id: Int): CustomerModel {
        return CustomerModel(
            idCustomer = id,
            nameCustomer = request.nameCustomer,
            telefoneCustomer = request.telefoneCustomer!!,
            emailCustomer = request.emailCustomer
        )
    }

    fun toResponse(model: CustomerModel): GetCustomerResponse {
        return GetCustomerResponse(
            nameCustomer = model.nameCustomer,
            emailCustomer = model.emailCustomer,
            telefoneCustomer = model.telefoneCustomer
        )
    }

    fun toAllResponse(customer: List<CustomerModel>): List<GetCustomerResponse> {

        return customer.map {

            GetCustomerResponse(
                nameCustomer = it.nameCustomer,
                emailCustomer = it.emailCustomer,
                telefoneCustomer = it.telefoneCustomer
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