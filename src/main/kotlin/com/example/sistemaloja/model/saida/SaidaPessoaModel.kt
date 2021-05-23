package com.example.sistemaloja.model.saida

import com.example.sistemaloja.domain.OrderDomain
import com.example.sistemaloja.model.EnderecoModel
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.*

@JsonInclude(Include.NON_NULL)
data class SaidaPessoaModel(

    val id: String? = null,

    val nome: String,

    val email: String?,

    val telefone: String?,

    val endereco: List<EnderecoModel>?,

    val ordens: List<OrderDomain>? = null
)
