package com.example.car_scheduling.repository

import com.example.car_scheduling.model.ServiceModel
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository: JpaRepository<ServiceModel, Int> {
}