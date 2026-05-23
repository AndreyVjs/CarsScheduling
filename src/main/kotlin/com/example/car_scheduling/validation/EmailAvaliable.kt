package com.example.car_scheduling.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

//@Target basicamente que tipo de coisa essa annotation vai tratar, no caso apenas campos/fields

@Constraint(validatedBy = [EmailAvaliableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailAvaliable(
    val message: String = "Email já cadastrado",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
