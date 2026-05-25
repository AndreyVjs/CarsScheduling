package com.example.car_scheduling.model;

import jakarta.persistence.Column
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "customer")
data class CustomerModel (
//    @Column("id_customer")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer")
    val idCustomer: Int? = null,

    @Column(name = "name_customer")
    val nameCustomer: String,

    @Column(name = "telefone_customer")
    val telefoneCustomer: Int,

    @Column(name = "email_customer")
    val emailCustomer: String,

    //OneToMany dis Um "DONO" para Muitos ...
    //mappedBy diz que isso tá referenciando a var customer lá em CarModel (Essa mesma com os Notatetions configurando)

    @OneToMany(mappedBy = "idCustomer")
    val vehicles: List<CarModel> = mutableListOf(),

    @OneToMany(mappedBy = "customer")
    val workOrders: List<WorkOrderModel> = mutableListOf()
)
