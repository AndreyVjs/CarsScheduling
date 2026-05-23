package com.example.car_scheduling.validation

import com.example.car_scheduling.service.CustomerService
import com.fasterxml.jackson.annotation.JacksonInject
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Valid
import kotlin.reflect.KClass


class EmailAvaliableValidator(

    val service: CustomerService
): ConstraintValidator<EmailAvaliable, String>{



    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean{

        if (value.isNullOrEmpty()) {
            return false
        }

        return service.existsByEmailCustomer(value)
    }
}
