package com.example.car_scheduling.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

//@Target basicamente que tipo de coisa essa annotation vai tratar, no caso apenas campos/fields

@Constraint(validatedBy = [PlateAvaliableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class PlateAvaliable(
    val message: String = "Essa placa já está cadastrada",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
