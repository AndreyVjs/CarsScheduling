package com.example.car_scheduling.controller

import com.example.car_scheduling.controller.dto.mapper.CustomerMapper
import com.example.car_scheduling.controller.dto.request.CreateCustomerRequest
import com.example.car_scheduling.controller.dto.response.CarResponse
import com.example.car_scheduling.controller.dto.response.GetCustomerResponse
import com.example.car_scheduling.model.CustomerModel
import com.example.car_scheduling.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer")
class CustomerController (

    val service: CustomerService,
    val mapper: CustomerMapper
){

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody request: CreateCustomerRequest) {
        service.createCustomer(mapper.toModel(request))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomerById(

        @PathVariable("id") id: Int
    ) {
            service.deleteCustomerById(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun putCustomer(
        @PathVariable("id") id: Int,
        @RequestBody request: CreateCustomerRequest
    ) {
        service.putCustomer(mapper.toModelById(request, id))
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCustomerById (
        @PathVariable("id") id: Int
    ): GetCustomerResponse {
        return mapper.toResponse(service.getCustomerById(id))
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllCustomers(): List<GetCustomerResponse> {
        return mapper.toAllResponse(service.getAllCustomers())
    }

    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getAllCarsById(

        @PathVariable("id") id: Int

    ): List<CarResponse> {

        return mapper.toCarsResponse(service.getAllCarsById(service.getCustomerById(id)))
    }
}