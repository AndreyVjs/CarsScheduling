package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateServiceRequest
import com.example.car_scheduling.controller.dto.response.CarResponse
import com.example.car_scheduling.controller.dto.response.ServiceResponse
import com.example.car_scheduling.model.ServiceModel
import org.springframework.stereotype.Component

@Component
class ServiceMapper (){

    fun toModel(request: CreateServiceRequest): ServiceModel {

        return ServiceModel(

            name_service = request.name_service,
            description_service = request.description_service,
            price_service = request.price_service,
            estimated_time_service = request.estimated_time_service,
            id_employee = request.id_employee,
            work_orders = request.work_orders
        )
    }

    fun toModelById(request: CreateServiceRequest, id: Int): ServiceModel {

        return ServiceModel(

            id_service = id,
            name_service = request.name_service,
            description_service = request.description_service,
            price_service = request.price_service,
            estimated_time_service = request.estimated_time_service,
            id_employee = request.id_employee,
            work_orders = request.work_orders
        )
    }

    fun toAllResponse(services: List<ServiceModel>): List<ServiceResponse> {

        return services.map {

            ServiceResponse(

                name_service = it.name_service,
                description_service = it.description_service,
                price_service = it.price_service,
                estimated_time_service = it.estimated_time_service,
                id_employee = it.id_employee,
                work_orders = it.work_orders
            )
        }
    }

    fun toResponse(service: ServiceModel): ServiceResponse {

        return ServiceResponse(

            name_service = service.name_service,
            description_service = service.description_service,
            price_service = service.price_service,
            estimated_time_service = service.estimated_time_service,
            id_employee = service.id_employee,
            work_orders = service.work_orders
        )
    }
}
