package com.example.sistemaloja.model.entrada

import com.example.sistemaloja.domain.CategoriaDomain

data class EntradaProdutoModel(
    val nome: String,

    val preco: Double,

    val quantidade: Integer,

    val categorias: Set<String>
)
