package com.brasiledu.apialuno.service.integration

import com.brasiledu.apialuno.model.Aluno
import org.springframework.stereotype.Service

@Service
class MecServiceIntegration {

    fun enviarInformacaoAluno(aluno: Aluno){
        println("iniciando envio de dados para o mec")
    }

}