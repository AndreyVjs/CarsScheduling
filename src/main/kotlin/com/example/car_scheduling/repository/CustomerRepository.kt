package com.example.car_scheduling.repository

import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CustomerRepository: JpaRepository<CustomerModel, Int> {

    @Query("Select g From CarModel g Where g.idCustomer = :idCustomer")
    fun getAllCarsById(idCustomer: CustomerModel): List<CarModel>

    fun existsByEmailCustomer(emailCustomer: String): Boolean

//    @Query()
//    fun findByEmail(email: String): String{
//        return "x"
//    }
}