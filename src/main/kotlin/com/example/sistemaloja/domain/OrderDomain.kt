package com.example.sistemaloja.domain

import com.example.sistemaloja.enum.OrderStatus
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "order")
data class OrderDomain(
        @Id
        val id: String? = null,

        val orderStatus: OrderStatus,

        @DBRef
        val products: List<ProdutoDomain>,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        val moment : Instant = Instant.now()
)
