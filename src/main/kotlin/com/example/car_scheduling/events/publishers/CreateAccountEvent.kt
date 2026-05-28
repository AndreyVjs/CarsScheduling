package com.example.car_scheduling.events.publishers

import com.example.car_scheduling.model.CustomerModel
import org.springframework.context.ApplicationEvent

class CreateAccountEvent(

    source: Any,
    val CustomerModel: CustomerModel
): ApplicationEvent(source)