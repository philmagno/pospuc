package com.brasiledu.apialuno.controller

import com.brasiledu.apialuno.model.Usuario
import com.brasiledu.apialuno.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UserController @Autowired constructor(var usuarioService: UsuarioService){

    @GetMapping
    fun listAll(){
        usuarioService.list()
    }

    @PostMapping
    fun saveAluno(@RequestBody usuario: Usuario) {
        usuarioService.save(usuario)
    }

    @GetMapping("/:userId")
    fun userInfo(@PathVariable("userId") userId: Long) {
        usuarioService.recuperarUsuario(userId)
    }

}