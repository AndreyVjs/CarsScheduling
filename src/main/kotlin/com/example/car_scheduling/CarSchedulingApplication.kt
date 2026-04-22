package com.example.car_scheduling

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarSchedulingApplication

fun main(args: Array<String>) {
	runApplication<CarSchedulingApplication>(*args)
}


// Customer deve ter Create, Update, Delete, GetId, GetAll, GetCars
// Service deve ter também o crud basico
//Car deve ser possivel Create Delete Update GetById GetAll


//Tirar esse getAllById não tem que passar model nenhum nisso
//E um repository so gerencis dus propria entidade não da pra chamar um no outro

//Arrumar o ManyToMany de employee com service