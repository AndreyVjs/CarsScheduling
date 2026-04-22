package com.example.car_scheduling.model;

import jakarta.persistence.Column
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "customer")
data class CustomerModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_customer: Int? = null,

    @Column
    val name_customer: String,

    @Column
    val telefone_customer: Int,

    @Column
    val email_customer: String,

    //OneToMany dis Um "DONO" para Muitos ...
    //mappedBy diz que isso tá referenciando a var customer lá em CarModel (Essa mesma com os Notatetions configurando)

    @OneToMany(mappedBy = "customer_id")
    val vehicles: List<CarModel> = mutableListOf(),

    @OneToMany(mappedBy = "customer")
    val work_orders: List<WorkOrderModel> = mutableListOf()
)
