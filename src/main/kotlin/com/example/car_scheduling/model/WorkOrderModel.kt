package com.example.car_scheduling.model

import com.example.car_scheduling.enums.StatusWorkOrder
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "work_order")
data class WorkOrderModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idWorkOrder: Int? = null,

    @Column
    val startDateWorkOrder: LocalDateTime? = null,

    @Column
    val endDateWorkOrder: LocalDateTime? = null,

    @Column
    val statusWorkOrder: StatusWorkOrder,

    //Uma ordem para muitos clients/serviços/carros
    @ManyToOne()
    @JoinColumn(name = "idCustomer")
    val customer: CustomerModel,

    @ManyToOne()
    @JoinColumn(name = "idCar")
    val car: CarModel,

    @ManyToMany()
    val services: List<ServiceModel> = mutableListOf()

)