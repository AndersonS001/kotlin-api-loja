package com.example.sistemaloja.service

import com.example.sistemaloja.domain.CategoriaDomain
import com.example.sistemaloja.model.entrada.EntradaCategoriaModel
import com.example.sistemaloja.model.saida.SaidaCategoriaModel
import com.example.sistemaloja.repository.CategoriaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.jvm.Throws

@Service
class CategoriaService(val categoriaRepository: CategoriaRepository) {

    fun cadastraCategoria(entradaCategoriaModel: EntradaCategoriaModel): SaidaCategoriaModel {
        val cat = categoriaRepository.save(CategoriaDomain(nome = entradaCategoriaModel.nome))

        return SaidaCategoriaModel(id = cat.id!!, nome = cat.nome)
    }

    fun obtemCategorias(): List<SaidaCategoriaModel> {
        val findAll = categoriaRepository.findAll()

        val lst = ArrayList<SaidaCategoriaModel>()

        for (cat in findAll)
            lst.add(SaidaCategoriaModel(id = cat.id!!, nome = cat.nome))

        return lst
    }

    fun removeCategorias() {
        categoriaRepository.deleteAll()
    }

    fun removeCategoria(id: String) {
        val cat = findById(id)

        categoriaRepository.delete(cat)
    }

    @Throws(ResponseStatusException::class)
    fun findById(id: String): CategoriaDomain {
        val findById = categoriaRepository.findById(id)

        if(!findById.isPresent)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria $id não encontrada")

        return findById.get()
    }

    fun getById(id: String): SaidaCategoriaModel {
        val cat = findById(id)

        return SaidaCategoriaModel(id= cat.id!!, nome = cat.nome)
    }

    fun atualizaCategoria(id: String, entradaCategoriaModel: EntradaCategoriaModel) {
        val cat = findById(id)

        cat.nome = entradaCategoriaModel.nome

        categoriaRepository.save(cat)
    }
}