package com.example.sistemaloja.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "categoria")
data class CategoriaDomain (

    @Id
    val id: String,

    val nome: String
)
