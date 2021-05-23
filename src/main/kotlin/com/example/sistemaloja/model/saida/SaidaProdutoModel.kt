package com.example.sistemaloja.model.saida

import com.example.sistemaloja.domain.CategoriaDomain
import com.example.sistemaloja.model.CategoriaModel
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SaidaProdutoModel(
    val id: String?,

    val nome: String,

    val preco: Double,

    val quantidade: Integer,

    val categorias: Set<CategoriaDomain>?
)
