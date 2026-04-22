package com.example.car_scheduling.service

import com.example.car_scheduling.controller.dto.request.CreateCustomerRequest
import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import com.example.car_scheduling.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(

    val repository: CustomerRepository
) {

    fun createCustomer( model: CustomerModel) {
        repository.save(model)
    }

    fun deleteCustomerById(id: Int) {
        repository.deleteById(id)
    }

    fun putCustomer(model: CustomerModel) {
       repository.save(model)
    }

    fun getCustomerById(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow()
    }

    fun getAllCustomers(): List<CustomerModel> {
        return repository.findAll()
    }

    fun getAllCarsById(customer_id: CustomerModel): List<CarModel> {
        return repository.getAllCarsById(customer_id)
    }
}