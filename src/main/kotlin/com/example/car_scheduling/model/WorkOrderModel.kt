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
    val id_work_order: Int? = null,

    @Column
    val start_date_work_order: LocalDateTime? = null,

    @Column
    val end_date_work_order: LocalDateTime? = null,

    @Column
    val status_work_order: StatusWorkOrder,

    //Uma ordem para muitos clients/serviços/carros
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,

    @ManyToOne()
    @JoinColumn(name = "id_car")
    val car: CarModel,

    @ManyToMany()
    val services: List<ServiceModel> = mutableListOf()

)