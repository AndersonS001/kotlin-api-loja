package com.example.sistemaloja.domain

import com.example.sistemaloja.model.EnderecoModel
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import javax.management.monitor.StringMonitor

@Document(collection = "pessoa")
data class PessoaDomain(
        @Id
        val id : String,

        val name: String,

        val email: String,

        val phone: String,

        val address: List<EnderecoModel>,

        @DBRef
        val orders: List<OrderDomain>
)
