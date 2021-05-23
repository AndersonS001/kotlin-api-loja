package com.example.sistemaloja.controller

import com.example.sistemaloja.model.entrada.EntradaCategoriaModel
import com.example.sistemaloja.model.saida.SaidaCategoriaModel
import com.example.sistemaloja.service.CategoriaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@ResponseBody
@RequestMapping("/categorias")
class CategoriaController(val categoriaService: CategoriaService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastraCategoria(@RequestBody entradaCategoriaModel: EntradaCategoriaModel) : SaidaCategoriaModel{
        return categoriaService.cadastraCategoria(entradaCategoriaModel)
    }

    @GetMapping
    fun obtemCategorias() : List<SaidaCategoriaModel>{
        return categoriaService.obtemCategorias()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): SaidaCategoriaModel{
        return categoriaService.getById(id)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeCategorias(){
        categoriaService.removeCategorias()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeCategoriaPorId(@PathVariable id:String){
        categoriaService.removeCategoria(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizaCategoria(@PathVariable id: String, @RequestBody entradaCategoriaModel: EntradaCategoriaModel){
        categoriaService.atualizaCategoria(id, entradaCategoriaModel)
    }
}