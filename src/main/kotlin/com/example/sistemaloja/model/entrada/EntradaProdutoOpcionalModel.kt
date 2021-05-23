package com.example.sistemaloja.model.entrada

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class EntradaProdutoOpcionalModel(
    val nome: String? = null,

    val preco: Double? = null,

    val quantidade: Integer? = null,

    val categorias: Set<String>? = null
)
