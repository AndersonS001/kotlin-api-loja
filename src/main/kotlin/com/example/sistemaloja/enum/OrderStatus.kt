package com.example.sistemaloja.enum

enum class OrderStatus(val code: Int) {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
}