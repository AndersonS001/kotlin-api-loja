package com.example.sistemaloja.service

import com.example.sistemaloja.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrdemService(val orderRepository: OrderRepository) {
}