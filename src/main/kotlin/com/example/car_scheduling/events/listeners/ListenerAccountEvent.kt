package com.example.car_scheduling.events.listeners

import com.example.car_scheduling.events.publishers.CreateAccountEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class ListenerAccountEvent {

    //Nesse Phase (phase = fase) eu especifico que só quero que a função execute quando o lugar que chamou for commitado no caso o commit sendo o return do banco
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun listenerCreateAccount(event: CreateAccountEvent){

        println("Conta do ${event.CustomerModel.nameCustomer} cadastrada!!")
    }
}