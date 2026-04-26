package com.example.car_scheduling.service
import com.example.car_scheduling.controller.dto.response.WorkOrderResponse
import com.example.car_scheduling.model.WorkOrderModel
import com.example.car_scheduling.repository.WorkOrderRepository
import org.springframework.stereotype.Service

@Service
class WorkOrderService (

    val repository: WorkOrderRepository
){
    fun postWorkOrder(model: WorkOrderModel) {

        repository.save(model)
    }

    fun getWorkOrderById(id: Int): WorkOrderModel {
        return repository.findById(id).orElseThrow()
    }
}