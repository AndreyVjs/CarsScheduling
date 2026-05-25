package com.example.car_scheduling.validation

import com.example.car_scheduling.service.CarService
import com.example.car_scheduling.validation.PlateAvaliable
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext


class PlateAvaliableValidator(

    val service: CarService
): ConstraintValidator<PlateAvaliable, String>{

        //O value é a placa
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean{

        if (value.isNullOrEmpty()) {
            return false
        }

        return service.existsByPlateCar(value)
    }
}