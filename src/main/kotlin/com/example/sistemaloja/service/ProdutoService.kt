package com.example.sistemaloja.service

import com.example.sistemaloja.domain.CategoriaDomain
import com.example.sistemaloja.domain.ProdutoDomain
import com.example.sistemaloja.model.entrada.EntradaProdutoModel
import com.example.sistemaloja.model.entrada.EntradaProdutoOpcionalModel
import com.example.sistemaloja.model.saida.SaidaProdutoModel
import com.example.sistemaloja.repository.ProdutoRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProdutoService(val produtoRepository: ProdutoRepository, val categoriaService: CategoriaService) {

    fun cadastraProduto(entradaProdutoModel: EntradaProdutoModel): SaidaProdutoModel {

        val cat = obtemCategorias(entradaProdutoModel.categorias)

        val p = produtoRepository.save(produtoDomain(entradaProdutoModel, cat))

        return saidaProdutoModel(p)
    }

    private fun obtemCategorias(categorias: Set<String>): Set<CategoriaDomain> {

        val lst = ArrayList<CategoriaDomain>()

        for (c in categorias)
            lst.add(categoriaService.findById(c))

        return lst.toSet()
    }

    private fun produtoDomain(entradaProdutoModel: EntradaProdutoModel, cat: Set<CategoriaDomain>) =
        ProdutoDomain(
            name = entradaProdutoModel.nome,
            price = entradaProdutoModel.preco,
            quantity = entradaProdutoModel.quantidade,
            categories = cat
        )

    private fun saidaProdutoModel(p: ProdutoDomain) = SaidaProdutoModel(
        id = p.id,
        nome = p.name,
        preco = p.price,
        quantidade = p.quantity,
        categorias = p.categories
    )

    fun obtemProdutos(): List<SaidaProdutoModel> {
        val produtos = produtoRepository.findAll()
        val lst = ArrayList<SaidaProdutoModel>()

        for (p in produtos)
            lst.add(saidaProdutoModel(p))

        return lst
    }

    fun getById(id: String): SaidaProdutoModel {

        val p = findById(id)

        return saidaProdutoModel(p)
    }

    private fun findById(id: String): ProdutoDomain {
        val p = produtoRepository.findById(id)

        if (!p.isPresent)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Produto $id não encontrado")

        return p.get()
    }

    fun removeProdutos() {
        produtoRepository.deleteAll()
    }

    fun removeProduto(id: String) {
        val p = findById(id)

        produtoRepository.delete(p)
    }

    fun atualizaProduto(id: String, entradaProdutoModel: EntradaProdutoModel) {
        val cat = obtemCategorias(entradaProdutoModel.categorias)

        val p = findById(id)
        val newP = produtoDomain(entradaProdutoModel, cat)
        newP.id = p.id

        produtoRepository.save(newP)
    }

    fun atualizaProdutoOpcional(id: String, entradaProdutoOpcionalModel: EntradaProdutoOpcionalModel) {
        var cat: Set<CategoriaDomain>? = null

        if (!entradaProdutoOpcionalModel.categorias.isNullOrEmpty())
            cat = obtemCategorias(entradaProdutoOpcionalModel.categorias)

        val p = findById(id)
        val newP = ProdutoDomain(
            id = p.id,
            name = entradaProdutoOpcionalModel?.nome ?: p.name,
            quantity = entradaProdutoOpcionalModel?.quantidade ?: p.quantity,
            price = entradaProdutoOpcionalModel?.preco ?: p.price,
            categories = cat ?: p.categories
        )

        produtoRepository.save(newP)
    }
}