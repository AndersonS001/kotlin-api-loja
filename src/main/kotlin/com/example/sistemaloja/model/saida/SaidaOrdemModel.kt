package com.example.sistemaloja.model.saida

import com.example.sistemaloja.enum.OrderStatus
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class SaidaOrdemModel(
    val id: String? = null,

    val cliente: SaidaPessoaModel?,

    val orderStatus: OrderStatus,

    val products: List<SaidaProdutoModel>,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    val moment: Instant
)
