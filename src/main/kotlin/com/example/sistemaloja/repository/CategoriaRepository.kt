package com.example.sistemaloja.repository

import com.example.sistemaloja.domain.CategoriaDomain
import org.springframework.data.mongodb.repository.MongoRepository

interface CategoriaRepository : MongoRepository<CategoriaDomain, String> {
}