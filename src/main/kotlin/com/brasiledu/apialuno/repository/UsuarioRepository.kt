package com.brasiledu.apialuno.repository

import com.brasiledu.apialuno.model.Usuario
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository : CrudRepository<Usuario, Long> {

    @Query("SELECT U from Usuario U where login = :nomeUsuario")
    fun encontrarUsuarioPeloLogin(nomeUsuario: String) : Usuario

}