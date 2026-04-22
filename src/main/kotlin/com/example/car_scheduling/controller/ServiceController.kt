package com.example.car_scheduling.controller

import com.example.car_scheduling.controller.dto.mapper.ServiceMapper
import com.example.car_scheduling.controller.dto.request.CreateServiceRequest
import com.example.car_scheduling.controller.dto.response.ServiceResponse
import com.example.car_scheduling.service.ServiceService
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
@RequestMapping("service")
class ServiceController(

    val service: ServiceService,
    val mapper: ServiceMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createService(@RequestBody request: CreateServiceRequest) {
        service.createService(mapper.toModel(request))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteService(
        @PathVariable("id") id: Int
    ) {
        service.deleteService(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun updateService(
        @RequestBody request: CreateServiceRequest,
        @PathVariable("id") id: Int
    ) {
        service.updateServiceById(mapper.toModelById(request,id))
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllServices(): List<ServiceResponse> {

        return mapper.toAllResponse(service.getAllServices())
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getServiceById(@PathVariable("id") id: Int): ServiceResponse {

        return mapper.toResponse(service.getServiceById(id))
    }
}