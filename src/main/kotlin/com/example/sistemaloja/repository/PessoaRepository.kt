package com.example.sistemaloja.repository

import com.example.sistemaloja.domain.PessoaDomain
import org.springframework.data.mongodb.repository.MongoRepository

interface PessoaRepository : MongoRepository<PessoaDomain, String> {
}