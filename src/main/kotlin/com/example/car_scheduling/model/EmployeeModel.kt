package com.example.car_scheduling.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

@Entity
@Table(name = "employee")
data class EmployeeModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idEmployee: Int? = null,

    @Column
    val nameEmployee: String,

    @Column
    val telefoneEmployee: String,

    @Column
    val emailEmployee: String,

    @Column
    val salaryEmployee: Float,

    @Column(updatable = false)
    val entryDateEmployee: LocalDateTime = LocalDateTime.now(),

    @Column
    val birthdayEmployee: LocalDate,

    @Column
    val roleEmployee: String,

    @ManyToMany(mappedBy = "idEmployee")
    val services: List<ServiceModel> = mutableListOf()


)