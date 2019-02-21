package com.brasiledu.apialuno.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "usuario")
data class Usuario constructor(
        @Id
        @GeneratedValue
        var id : Long,
        var nome: String):Serializable
