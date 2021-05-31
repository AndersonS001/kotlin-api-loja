package com.example.sistemaloja.model.entrada

import com.example.sistemaloja.enum.OrderStatus

data class EntradaOrdemModel(
    val cliente: String,

    val orderStatus: OrderStatus,

    val products: List<String>
)
