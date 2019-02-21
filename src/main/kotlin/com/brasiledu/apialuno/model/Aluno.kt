package com.brasiledu.apialuno.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "aluno")
class Aluno constructor(
        @Id
        @GeneratedValue
        var id : Long,
        var nome: String,
        var cpf: String,
        @OneToOne
        var usuario: Usuario): Serializable
