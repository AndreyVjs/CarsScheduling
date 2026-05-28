package com.example.car_scheduling.events.listeners

import com.example.car_scheduling.events.publishers.DeleteCustomerAccountEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class ListenerDeleteCustomerAccountEvent {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    fun spamMessage(event: DeleteCustomerAccountEvent){
        println("Limpando históricos de agendamentos e carros associados ao cliente ${event.CustomerModel.nameCustomer} de ID: ${event.CustomerModel.idCustomer}")
    }
}