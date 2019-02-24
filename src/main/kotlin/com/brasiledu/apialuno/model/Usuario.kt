package com.brasiledu.apialuno.model

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario constructor(
        @Id
        @GeneratedValue
        var id : Long,
        var login: String,
        var senha: String,
        @Column(name = "data_nascimento")
        var dataNascimento: Date,
        var nome: String,
        var cpf: String,
        var email: String,
        @Column(name = "ultimo_acesso")
        var ultimoAcesso: Date,
        var role: String): Serializable
