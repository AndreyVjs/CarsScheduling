package com.example.car_scheduling.controller.dto.mapper

import com.example.car_scheduling.controller.dto.request.CreateWorkOrderRequest
import com.example.car_scheduling.controller.dto.request.PutWorkOrderRequest
import com.example.car_scheduling.controller.dto.response.WorkOrderResponse
import com.example.car_scheduling.enums.StatusWorkOrder
import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import com.example.car_scheduling.model.ServiceModel
import com.example.car_scheduling.model.WorkOrderModel
import com.example.car_scheduling.service.CarService
import com.example.car_scheduling.service.CustomerService
import com.example.car_scheduling.service.ServiceService
import com.example.car_scheduling.service.WorkOrderService
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class WorkOrderMapper (

    val CustomerService: CustomerService,
    val CarService: CarService,
    val ServiceService: ServiceService,
    val WorkOrderService: WorkOrderService
){

    fun toModel(request : CreateWorkOrderRequest): WorkOrderModel {

        if (request.startDateWorkOrder == null){

            var dateNow = LocalDateTime.now()
            var status = StatusWorkOrder.INICIO

            return WorkOrderModel(

                startDateWorkOrder = dateNow,
                statusWorkOrder = status,
                customer = CustomerService.getCustomerById(request.idCustomer),
                car = CarService.getCarByid(request.idCar),
                services = request.idService.map {
                    ServiceService.getServiceById(it)
                }
            )

        } else {

            var status = StatusWorkOrder.ANADAMENTO

            return WorkOrderModel(

                startDateWorkOrder = request.startDateWorkOrder,
                statusWorkOrder = status,
                customer = CustomerService.getCustomerById(request.idCustomer),
                car = CarService.getCarByid(request.idCar),
                services = request.idService.map {
                    ServiceService.getServiceById(it)
                }
            )
        }
    }

    fun toAllResponse(model: List<WorkOrderModel>): List<WorkOrderResponse>{


        return model.map {

            WorkOrderResponse(

             it.startDateWorkOrder!!,

             it.endDateWorkOrder!!,

             it.statusWorkOrder,

             it.customer,

             it.car,

             it.services
            )
        }
    }

    fun toModelById(id: Int, request: PutWorkOrderRequest): WorkOrderModel {

        if (request.idService == null || request.idCar == null || request.idCustomer == null) {

            var wordOrder = WorkOrderService.getWorkOrderById(id)

            return WorkOrderModel(

                idWorkOrder = wordOrder.idWorkOrder,

                startDateWorkOrder = wordOrder.startDateWorkOrder,

                endDateWorkOrder = wordOrder.endDateWorkOrder,

                statusWorkOrder = request.statusWorkOrder,

                customer = wordOrder.customer,

                car = wordOrder.car,

                services = wordOrder.services
            )

        } else {

            return WorkOrderModel(

                idWorkOrder = id,
                statusWorkOrder = request.statusWorkOrder,
                customer = CustomerService.getCustomerById(request.idCustomer!!),
                car = CarService.getCarByid(request.idCar!!),
                services = request.idService!!.map {
                    ServiceService.getServiceById(it)
                }
            )
        }

    }
}