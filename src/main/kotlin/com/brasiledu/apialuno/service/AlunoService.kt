package com.brasiledu.apialuno.service

import com.brasiledu.apialuno.model.Aluno
import com.brasiledu.apialuno.repository.AlunoRepository
import com.brasiledu.apialuno.service.integration.MecServiceIntegration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AlunoService @Autowired constructor(var alunoRepository: AlunoRepository, var mecServiceIntegration: MecServiceIntegration) {

    fun save(aluno: Aluno){
        alunoRepository.save(aluno)
        mecServiceIntegration.enviarInformacaoAluno(aluno)
    }

    fun list(): MutableIterable<Aluno> = alunoRepository.findAll()

    fun consultarDadosPessoais(userId: Long) = alunoRepository.findById(userId)
}