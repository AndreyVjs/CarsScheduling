package com.example.car_scheduling.enums

enum class Errors( val message: String, val errorCode: String) {

    //De 100 a 200 é X
    ML101("Esse customer de id [%s] não existe!","CS-101"), //Customer
    ML201("Esse carro de id [%s] não existe!","CS-201"), //Car
    ML301("Esse employee de id [%s] não existe!","CS-301"), //Employee
    ML401("Não existe nenhum service com esse id [%s]","CS-401"), //Service
    ML501("Não existe nenhuma work order com esse id [%s]","CS-501") //WorkOrder
}