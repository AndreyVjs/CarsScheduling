package com.example.car_scheduling.service

import com.example.car_scheduling.enums.Errors
import com.example.car_scheduling.events.publishers.CreateAccountEvent
import com.example.car_scheduling.events.publishers.DeleteCustomerAccountEvent
import com.example.car_scheduling.exception.NotFoundException
import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import com.example.car_scheduling.repository.CustomerRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import kotlin.collections.List

@Service
class CustomerService(

    val repository: CustomerRepository,
    val carService: CarService,
    val publisherEvent: ApplicationEventPublisher
) {

    fun createCustomer( model: CustomerModel) {
        repository.save(model)

        publisherEvent.publishEvent(CreateAccountEvent(this, model))
    }

    //Tá faltando a logica:
    //Quando eu deleto um cliente tenho que deletar seus carros também
    //E a logica do se id for invalido
    //E adicionar um evento personalizado quando for deleteado
    fun deleteCustomerById(id: Int) {

        //Lista de carros
        val cars = getAllCarsById(getCustomerById(id))

        //Deleta os carros se tiver
        for (i in cars) {

            if (i.idCar == null)
                break

            carService.deleteCarById(i.idCar!!)
        }

        repository.deleteById(id)
        
        publisherEvent.publishEvent(DeleteCustomerAccountEvent(this, getCustomerById(id)))

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