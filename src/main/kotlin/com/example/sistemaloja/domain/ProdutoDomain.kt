package com.example.sistemaloja.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "produto")
data class ProdutoDomain(
        @Id
        val id: String,

        val name: String,

        val price: Double,

        val quantity: Integer,

        val categories: Set<CategoriaDomain>
)
