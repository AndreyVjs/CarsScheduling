package com.example.car_scheduling.service

import com.example.car_scheduling.enums.Errors
import com.example.car_scheduling.exception.NotFoundException
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

//        if(id == null){
//            throw
//        }
    }

    fun putCustomer(model: CustomerModel) {
       repository.save(model)
    }

    fun getCustomerById(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow { (NotFoundException(Errors.ML101.message.format(id), Errors.ML101.errorCode)) } //Fazer tratamento de erro emcima desse .orElseThrow()
    }

    fun getAllCustomers(): List<CustomerModel> {
        return repository.findAll()
    }

    fun getAllCarsById(customer_id: CustomerModel): List<CarModel> {
        return repository.getAllCarsById(customer_id)
    }

    fun existsByEmailCustomer(emailCustomer: String): Boolean {
        return !repository.existsByEmailCustomer(emailCustomer)
    }

//    fun vericateLogin(request: customerLoginRequest) {}
}