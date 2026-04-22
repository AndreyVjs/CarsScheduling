package com.example.car_scheduling.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "car")
data class CarModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_car: Int? = null,

    @Column
    val name_car: String,

    @Column
    val color: String,

    @Column
    val mark_car: String,

    @Column
    val plate_car: String,

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    val customer_id: CustomerModel,

    @OneToMany(mappedBy = "car")
    val work_orders: List<WorkOrderModel> = mutableListOf()


)