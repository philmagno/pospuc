package com.brasiledu.apialuno.model

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Long = 0,
        var login: String?? = null,
        var senha: String?? = null,
        @Column(name = "data_nascimento")
        var dataNascimento: Date?? = null,
        var nome: String?? = null,
        var cpf: String?? = null,
        var email: String?? = null,
        @Column(name = "ultimo_acesso")
        var ultimoAcesso: Date?? = null,
        var role: String?? = null): Serializable
