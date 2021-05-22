package com.example.sistemaloja.controller

import com.example.sistemaloja.service.ProdutoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@ResponseBody
@RequestMapping("/produtos")
class ProdutoController(val produtoService: ProdutoService) {

}