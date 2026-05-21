package com.example.car_scheduling.controller

import com.example.car_scheduling.controller.dto.mapper.EmployeeMapper
import com.example.car_scheduling.controller.dto.request.CreateEmployeeRequest
import com.example.car_scheduling.controller.dto.response.EmployeeResponse
import com.example.car_scheduling.service.EmployeeService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
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
@RequestMapping("employee")
@CrossOrigin(origins = ["*"])
class EmployeeController(

    val service: EmployeeService,
    val mapper: EmployeeMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createEmployee(@RequestBody @Valid request: CreateEmployeeRequest) {
        service.createEmployee(mapper.toModel(request))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEmployeeById(

        @PathVariable("id") id: Int
    ) {
        service.deleteEmployeeById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun updateEmployeeById(

        @RequestBody @Valid request: CreateEmployeeRequest,
        @PathVariable("id") id: Int) {

        service.updateEmployeeById(mapper.toModelById(request,id))
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllEmployee(): List<EmployeeResponse> {
        return mapper.toResponse(service.getAllEmployee())
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getEmployeeById(@PathVariable("id") id: Int): EmployeeResponse {
        return mapper.toResponseById(service.getEmployeeById(id))
    }
}