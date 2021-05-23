package com.example.sistemaloja.service

import com.example.sistemaloja.domain.PessoaDomain
import com.example.sistemaloja.model.entrada.EntradaPessoaModel
import com.example.sistemaloja.model.saida.SaidaPessoaModel
import com.example.sistemaloja.repository.PessoaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PessoaService(val pessoaRepository: PessoaRepository) {
    fun cadastraPessoa(entradaPessoaModel: EntradaPessoaModel): SaidaPessoaModel {
        val pessoa = pessoaRepository.save(
            entradaPessoaDomain(entradaPessoaModel)
        )

        return saidaPessoaModel(pessoa)
    }

    fun obtemPessoas(): List<SaidaPessoaModel> {
        val pessoas = pessoaRepository.findAll()

        val lst = ArrayList<SaidaPessoaModel>()

        for (p in pessoas)
            lst.add(
                saidaPessoaModel(p)
            )

        return lst
    }

    private fun entradaPessoaDomain(entradaPessoaModel: EntradaPessoaModel) = PessoaDomain(
        name = entradaPessoaModel.nome,
        email = entradaPessoaModel.email,
        phone = entradaPessoaModel.telefone,
        address = entradaPessoaModel.endereco
    )

    private fun saidaPessoaModel(p: PessoaDomain) = SaidaPessoaModel(
        id = p.id,
        nome = p.name,
        email = p.email,
        telefone = p.phone,
        endereco = p.address,
        ordens = p.orders
    )

    fun obtemPessoaPorId(id: String): SaidaPessoaModel {
        val p = findById(id)

        return saidaPessoaModel(p)
    }

    private fun findById(id: String): PessoaDomain {
        val findById = pessoaRepository.findById(id)

        if (!findById.isPresent)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada")

        return findById.get()
    }

    fun removePessoas() {
        pessoaRepository.deleteAll()
    }

    fun removePessoaPorId(id: String) {
        val p = findById(id)

        pessoaRepository.delete(p)
    }

    fun atualizaPessoa(id: String, entradaPessoaModel: EntradaPessoaModel) {
        val p = findById(id)

        val newP = entradaPessoaDomain(entradaPessoaModel)
        newP.id = p.id
        newP.orders = p.orders

        pessoaRepository.save(newP)
    }
}