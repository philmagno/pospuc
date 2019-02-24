package com.brasiledu.apialuno.service.integration

import com.brasiledu.apialuno.dto.AlunoDTO
import org.springframework.stereotype.Service

@Service
class MecServices() {

    fun enviarDadosDeAluno(alunoDTO: AlunoDTO) {
        println("Enviado para o MEC")
    }
}