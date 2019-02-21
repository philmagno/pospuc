package com.brasiledu.apialuno.repository

import com.brasiledu.apialuno.model.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository : CrudRepository<Usuario, Long> {

}