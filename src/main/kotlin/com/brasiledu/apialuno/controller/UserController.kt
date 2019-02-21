package com.brasiledu.apialuno.controller

import com.brasiledu.apialuno.repository.UsuarioRepository
import com.brasiledu.apialuno.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UserController @Autowired constructor(var usuarioService: UsuarioService){

    @GetMapping
    fun listAll(){
        usuarioService.list()
    }

}