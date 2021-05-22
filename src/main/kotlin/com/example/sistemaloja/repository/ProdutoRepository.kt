package com.example.sistemaloja.repository

import com.example.sistemaloja.domain.ProdutoDomain
import org.springframework.data.mongodb.repository.MongoRepository

interface ProdutoRepository : MongoRepository<ProdutoDomain, String> {
}