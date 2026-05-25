package com.example.car_scheduling.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "service")
data class ServiceModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idService: Int? = null,

    @Column
    val nameService: String,

    @Column
    val descriptionService: String,

    @Column
    val priceService: Float,

    @Column
    val estimatedTimeService: String,

    @ManyToMany()
    val idEmployee: List<EmployeeModel> = mutableListOf(),

    @ManyToMany(mappedBy = "services")
    val workOrders: List<WorkOrderModel>? = mutableListOf()
)