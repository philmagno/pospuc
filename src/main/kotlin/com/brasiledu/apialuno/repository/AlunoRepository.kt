package com.brasiledu.apialuno.repository

import com.brasiledu.apialuno.model.Aluno
import com.brasiledu.apialuno.model.Usuario
import org.springframework.data.repository.CrudRepository

interface AlunoRepository : CrudRepository<Aluno, Long> {

}