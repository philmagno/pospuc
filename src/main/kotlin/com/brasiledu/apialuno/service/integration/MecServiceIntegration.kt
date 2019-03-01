package com.brasiledu.apialuno.service.integration

import com.brasiledu.apialuno.dto.AlunoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MecServiceIntegration @Autowired constructor(var mecServices: MecServices) {

    fun enviarInformacaoAluno(aluno: AlunoDTO) {
        mecServices.enviarDadosDeAluno(aluno)
    }

}