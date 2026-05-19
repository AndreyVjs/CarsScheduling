package com.example.car_scheduling.service

import com.example.car_scheduling.enums.Errors
import com.example.car_scheduling.exception.NotFoundException
import com.example.car_scheduling.model.ServiceModel
import com.example.car_scheduling.repository.ServiceRepository
import org.springframework.stereotype.Service

@Service
class ServiceService(
    val repository: ServiceRepository
) {
    fun createService(model: ServiceModel) {
        repository.save(model)
    }

    fun deleteService(id: Int) {
        repository.deleteById(id)
    }

    fun updateServiceById(model: ServiceModel) {
        repository.save(model)
    }

    fun getAllServices(): List<ServiceModel> {
        return repository.findAll()
    }

    fun getServiceById(id: Int): ServiceModel {
        return repository.findById(id).orElseThrow{ (NotFoundException(Errors.ML401.message.format(id), Errors.ML401.errorCode)) }
    }

}