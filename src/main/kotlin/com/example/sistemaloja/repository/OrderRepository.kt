package com.example.sistemaloja.repository

import com.example.sistemaloja.domain.OrderDomain
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<OrderDomain,String> {
}