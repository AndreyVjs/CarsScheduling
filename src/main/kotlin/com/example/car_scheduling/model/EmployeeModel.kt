package com.example.car_scheduling.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.Date

@Entity
@Table(name = "employee")
data class EmployeeModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_employee: Int? = null,

    @Column
    val name_employee: String,

    @Column
    val telefone_employee: String,

    @Column
    val email_employee: String,

    @Column
    val salary_employee: Float,

    @Column(updatable = false)
    val entry_date_employee: LocalDateTime = LocalDateTime.now(),

    @Column
    val birthday_employee: Date,

    @Column
    val role_employee: String,

    @ManyToMany(mappedBy = "id_employee")
    val service: List<ServiceModel> = mutableListOf()


)