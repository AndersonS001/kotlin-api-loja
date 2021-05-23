package com.example.sistemaloja.controller

import com.example.sistemaloja.model.entrada.EntradaProdutoModel
import com.example.sistemaloja.model.entrada.EntradaProdutoOpcionalModel
import com.example.sistemaloja.model.saida.SaidaProdutoModel
import com.example.sistemaloja.service.ProdutoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@ResponseBody
@RequestMapping("/produtos")
class ProdutoController(val produtoService: ProdutoService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastraProduto(@RequestBody entradaProdutoModel: EntradaProdutoModel): SaidaProdutoModel {
        return produtoService.cadastraProduto(entradaProdutoModel)
    }

    @GetMapping
    fun obtemProdutos(): List<SaidaProdutoModel> {
        return produtoService.obtemProdutos()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): SaidaProdutoModel {
        return produtoService.getById(id)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeProdutos() {
        produtoService.removeProdutos()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeProdutoPorId(@PathVariable id: String) {
        produtoService.removeProduto(id)
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizaProduto(@PathVariable id: String, @RequestBody entradaProdutoModel: EntradaProdutoModel) {
        produtoService.atualizaProduto(id, entradaProdutoModel)
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizaProdutoSimples(
        @PathVariable id: String,
        @RequestBody entradaProdutoOpcionalModel: EntradaProdutoOpcionalModel
    ) {
        produtoService.atualizaProdutoOpcional(id, entradaProdutoOpcionalModel)
    }
}