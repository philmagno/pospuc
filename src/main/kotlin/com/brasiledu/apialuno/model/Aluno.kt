package com.brasiledu.apialuno.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "aluno")
data class Aluno constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Long = 0,
        var ra: String = "",
        @OneToOne
        @JoinColumn(name = "usuario_id")
        var usuario: Usuario = Usuario()): Serializable
