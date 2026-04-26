package com.example.car_scheduling.repository

import com.example.car_scheduling.model.CarModel
import com.example.car_scheduling.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CustomerRepository: JpaRepository<CustomerModel, Int> {

    @Query("Select g From CarModel g Where g.customer_id = :customer_id")
    fun getAllCarsById(customer_id: CustomerModel): List<CarModel>

//    @Query()
//    fun findByEmail(email: String): String{
//        return "x"
//    }
}