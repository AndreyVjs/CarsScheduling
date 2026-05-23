package com.example.car_scheduling.controller.dto.request

import com.example.car_scheduling.validation.EmailAvaliable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.NotFound
import org.springframework.boot.context.properties.bind.Name

data class CreateCustomerRequest (

    //Sim isso começa com letra minuscula por algum motivo, a unica hash até hoje que começa assim
    //Deve ser por que é do jakarta e não do Spring em si, mas pensando assim o Valid é maiusculo, vai entender ...

    @field:NotEmpty
    val nameCustomer: String,

    //O correto seria esse telefone ser String
    //Se coloca como pode ser nulo para isso ser tratado como um interger(Objeto), e se isso é um objeto ele pode ser tratado como nulo logo o NotNull vai funcionar
    @field: NotNull
    val telefoneCustomer: Int?,

    @EmailAvaliable
    val emailCustomer: String

)
