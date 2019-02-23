package com.brasiledu.apialuno.service

import com.brasiledu.apialuno.model.Usuario
import com.brasiledu.apialuno.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService @Autowired constructor(var usuarioRepository: UsuarioRepository) {

    fun save(usuario: Usuario){
        usuarioRepository.save(usuario)
    }

    fun recuperarUsuario(userId: Long){
        usuarioRepository.findById(userId)
    }

    fun list(): MutableIterable<Usuario> {
        return usuarioRepository.findAll()
    }
}