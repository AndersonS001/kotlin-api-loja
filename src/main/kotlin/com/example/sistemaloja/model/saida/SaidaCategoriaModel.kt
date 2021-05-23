package com.example.sistemaloja.model.saida

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SaidaCategoriaModel(
    val id: String,

    val nome: String
)
