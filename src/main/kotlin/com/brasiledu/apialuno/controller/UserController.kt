package com.brasiledu.apialuno.controller

import com.brasiledu.apialuno.model.Aluno
import com.brasiledu.apialuno.model.Usuario
import com.brasiledu.apialuno.repository.UsuarioRepository
import com.brasiledu.apialuno.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UserController @Autowired constructor(var usuarioService: UsuarioService){

    @GetMapping
    fun listAll(){
        usuarioService.list()
    }

    @PostMapping
    fun saveAluno(@RequestBody usuario: Aluno) {
        println(usuario)
        //usuarioService.save(usuario)
    }

}