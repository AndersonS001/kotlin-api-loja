package com.example.sistemaloja.controller

import com.example.sistemaloja.model.entrada.EntradaPessoaModel
import com.example.sistemaloja.model.saida.SaidaPessoaModel
import com.example.sistemaloja.service.PessoaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@ResponseBody
@RequestMapping("/pessoas")
class PessoaController(val pessoaService: PessoaService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastraPessoa(@RequestBody entradaPessoaModel: EntradaPessoaModel): SaidaPessoaModel {
        return pessoaService.cadastraPessoa(entradaPessoaModel)
    }

    @GetMapping
    fun obtemPessoas(): List<SaidaPessoaModel> {
        return pessoaService.obtemPessoas()
    }

    @GetMapping("/{id}")
    fun obtemPessoaPorId(@PathVariable id: String): SaidaPessoaModel {
        return pessoaService.obtemPessoaPorId(id)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removePessoas(){
        pessoaService.removePessoas()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removePessoaPorId(@PathVariable id:String){
        pessoaService.removePessoaPorId(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizaPessoa(@PathVariable id: String, @RequestBody entradaPessoaModel: EntradaPessoaModel){
        pessoaService.atualizaPessoa(id, entradaPessoaModel)
    }

}