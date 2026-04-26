package com.example.car_scheduling.controller

import com.example.car_scheduling.service.WorkOrderService
import com.example.car_scheduling.controller.dto.mapper.CustomerMapper
import com.example.car_scheduling.controller.dto.mapper.WorkOrderMapper
import com.example.car_scheduling.controller.dto.request.CreateWorkOrderRequest
import com.example.car_scheduling.controller.dto.response.WorkOrderResponse
import com.example.car_scheduling.model.WorkOrderModel
import com.example.car_scheduling.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/work-order")
class WorkOrderController (

    val service: WorkOrderService,
    val mapper: WorkOrderMapper
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postWorkOrder(@RequestBody request: CreateWorkOrderRequest) {

        service.postWorkOrder(mapper.toModel(request))
    }

//    @GetMapping
//    fun getAllWorkOrder() {
//
//    }
//
    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    fun getWorkOrderById(@PathVariable("id") id: Int): WorkOrderModel {

        return service.getWorkOrderById(id)
    }
}