package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateServiceRequest
import com.example.car_scheduling.controller.dto.response.CarResponse
import com.example.car_scheduling.controller.dto.response.ServiceResponse
import com.example.car_scheduling.model.ServiceModel
import com.example.car_scheduling.service.EmployeeService
import com.example.car_scheduling.service.WorkOrderService
import org.springframework.stereotype.Component

@Component
class ServiceMapper(

    val EmployeeService: EmployeeService,
    val WorkOrderService: WorkOrderService
){

    fun toModel(request: CreateServiceRequest): ServiceModel {

        return ServiceModel(

            nameService = request.nameService,
            descriptionService = request.descriptionService,
            priceService = request.priceService,
            estimatedTimeService = request.estimatedTimeService,
            idEmployee = request.idEmployee.map {
                EmployeeService.getEmployeeById(it)
            },
            workOrders = request.workOrders?.map{
                WorkOrderService.getWorkOrderById(it)
            }
        )
    }

    fun toModelById(request: CreateServiceRequest, id: Int): ServiceModel {

        return ServiceModel(

            idService = id,
            nameService = request.nameService,
            descriptionService = request.descriptionService,
            priceService = request.priceService,
            estimatedTimeService = request.estimatedTimeService,
            idEmployee = request.idEmployee.map {
                EmployeeService.getEmployeeById(it)
            },
            workOrders = request.workOrders?.map{
                WorkOrderService.getWorkOrderById(it)
            }
        )
    }

    fun toAllResponse(services: List<ServiceModel>): List<ServiceResponse> {

        return services.map {

            ServiceResponse(

                nameService = it.nameService,
                descriptionService = it.descriptionService,
                priceService = it.priceService,
                estimatedTimeService = it.estimatedTimeService,
                idEmployee = it.idEmployee,
                workOrders = it.workOrders
            )
        }
    }

    fun toResponse(service: ServiceModel): ServiceResponse {

        return ServiceResponse(

            nameService = service.nameService,
            descriptionService = service.descriptionService,
            priceService = service.priceService,
            estimatedTimeService = service.estimatedTimeService,
            idEmployee = service.idEmployee,
            workOrders = service.workOrders
        )
    }
}
