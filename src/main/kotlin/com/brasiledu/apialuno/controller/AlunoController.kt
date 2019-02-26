package com.brasiledu.apialuno.controller

import com.brasiledu.apialuno.dto.AlunoDTO
import com.brasiledu.apialuno.model.Aluno
import com.brasiledu.apialuno.service.AlunoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
class AlunoController @Autowired constructor(var alunoService: AlunoService){

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    fun listAll() = alunoService.list()

    @PostMapping(consumes = ["application/json"])
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    fun saveAluno(@RequestBody usuario: AlunoDTO) = alunoService.save(usuario)

    @GetMapping("/:alunoId")
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    fun userInfo(@PathVariable alunoId: Long) = alunoService.consultarDadosPessoais(alunoId)

}