package com.example.car_scheduling.events.publishers

import com.example.car_scheduling.model.CustomerModel
import org.hibernate.annotations.Source
import org.springframework.context.ApplicationEvent

class DeleteCustomerAccountEvent(

    source: Any,
    val CustomerModel: CustomerModel
): ApplicationEvent(source) {
}