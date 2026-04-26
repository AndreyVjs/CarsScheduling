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
    val id_service: Int? = null,

    @Column
    val name_service: String,

    @Column
    val description_service: String,

    @Column
    val price_service: Float,

    @Column
    val estimated_time_service: String,

    @ManyToMany()
    val id_employee: List<EmployeeModel> = mutableListOf(),

    @ManyToMany(mappedBy = "services")
    val work_orders: List<WorkOrderModel>? = mutableListOf()
)