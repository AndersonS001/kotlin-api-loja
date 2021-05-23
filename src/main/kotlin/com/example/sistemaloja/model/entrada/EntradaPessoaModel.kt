package com.example.sistemaloja.model.entrada

import com.example.sistemaloja.model.EnderecoModel

data class EntradaPessoaModel(
    val nome: String,

    val email: String? = null,

    val telefone: String? = null,

    val endereco: List<EnderecoModel>? = null
)
