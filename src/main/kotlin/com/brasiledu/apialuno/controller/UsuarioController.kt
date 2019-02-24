package com.brasiledu.apialuno.controller

import com.brasiledu.apialuno.model.Usuario
import com.brasiledu.apialuno.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController @Autowired constructor(var usuarioService: UsuarioService) {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') OR hasRole('ATTENDANT')")
    fun listAll(): MutableIterable<Usuario> = usuarioService.list()

    @GetMapping("/:userId")
    @PreAuthorize("hasRole('USER')")
    fun userInfo(@PathVariable("userId") userId: Long) = usuarioService.recuperarUsuario(userId)

}