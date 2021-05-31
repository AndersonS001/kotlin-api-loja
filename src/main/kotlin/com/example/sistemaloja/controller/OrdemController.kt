package com.example.sistemaloja.controller

import com.example.sistemaloja.model.entrada.EntradaOrdemModel
import com.example.sistemaloja.model.saida.SaidaOrdemModel
import com.example.sistemaloja.service.OrdemService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@ResponseBody
@RequestMapping("/ordens")
class OrdemController(val ordemService: OrdemService) {

}
/*@PostMapping
@ResponseStatus(HttpStatus.CREATED)
fun cadastraOrdem(@RequestBody entradaOrdemModel: EntradaOrdemModel) : SaidaOrdemModel {
    return ordemService.cadastraOrdem(entradaOrdemModel)
}

/*@GetMapping
fun obmOrdens() : List<SaidaOrdemModel>{
    return ordemService.obtemOrdens()
}

@GetMapping("/{id}")
fun getById(@PathVariable id: String): SaidaOrdemModel {
    return ordemService.getById(id)
}

@DeleteMapping
@ResponseStatus(HttpStatus.NO_CONTENT)
fun removeOrdems(){
    ordemService.removeOrdems()
}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
fun removeOrdemPorId(@PathVariable id:String){
    ordemService.removeOrdem(id)
}

@PutMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
fun atualizaOrdem(@PathVariable id: String, @RequestBody entradaOrdemModel: EntradaOrdemModel){
    ordemService.atualizaOrdem(id, entradaOrdemModel)
}
}*/