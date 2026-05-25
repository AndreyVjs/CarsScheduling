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
    val idCar: Int? = null,

    @Column(name = "name_car")
    val nameCar: String,

    @Column(name = "color")
    val colorCar: String,

    @Column(name = "mark_car")
    val markCar: String,

    @Column(name = "plate_car")
    val plateCar: String,

    @ManyToOne()
    @JoinColumn(name = "idCustomer")
    val idCustomer: CustomerModel,

    @OneToMany(mappedBy = "car")
    val workOrders: List<WorkOrderModel> = mutableListOf()


)