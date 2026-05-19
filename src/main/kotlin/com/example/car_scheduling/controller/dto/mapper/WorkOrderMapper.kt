package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateWorkOrderRequest
import com.example.car_scheduling.enums.StatusWorkOrder
import com.example.car_scheduling.model.WorkOrderModel
import com.example.car_scheduling.service.CarService
import com.example.car_scheduling.service.CustomerService
import com.example.car_scheduling.service.ServiceService
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class WorkOrderMapper (

    val CustomerService: CustomerService,
    val CarService: CarService,
    val ServiceService: ServiceService
){

    fun toModel(request : CreateWorkOrderRequest): WorkOrderModel {

        if (request.start_date_work_order == null){

            var dateNow = LocalDateTime.now()
            var status = StatusWorkOrder.INICIO

            return WorkOrderModel(

                start_date_work_order = dateNow,
                status_work_order = status,
                customer = CustomerService.getCustomerById(request.id_customer),
                car = CarService.getCarByid(request.id_car),
                services = request.id_service.map {
                    ServiceService.getServiceById(it)
                }
            )

        } else {

            var status = StatusWorkOrder.ANADAMENTO

            return WorkOrderModel(

                start_date_work_order = request.start_date_work_order,
                status_work_order = status,
                customer = CustomerService.getCustomerById(request.id_customer),
                car = CarService.getCarByid(request.id_car),
                services = request.id_service.map {
                    ServiceService.getServiceById(it)
                }
            )
        }
    }

//    fun toResponse(model: WorkOrderModel): WorkOrderResponse{
//
//        WorkOrderResponse(
//
//
//        )
//    }
}