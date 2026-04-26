package com.example.car_scheduling.repository

import com.example.car_scheduling.model.WorkOrderModel
import org.springframework.data.jpa.repository.JpaRepository

interface WorkOrderRepository: JpaRepository<WorkOrderModel, Int> {
}