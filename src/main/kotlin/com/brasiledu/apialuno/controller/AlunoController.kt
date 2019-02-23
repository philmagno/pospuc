package com.brasiledu.apialuno.controller

import com.brasiledu.apialuno.model.Aluno
import com.brasiledu.apialuno.service.AlunoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
class AlunoController @Autowired constructor(var alunoService: AlunoService){

    @GetMapping
    fun listAll() = alunoService.list()

    @PostMapping
    fun saveAluno(@RequestBody usuario: Aluno) = alunoService.save(usuario)

    @GetMapping("/:alunoId")
    fun userInfo(@PathVariable alunoId: Long) = alunoService.consultarDadosPessoais(alunoId)

}