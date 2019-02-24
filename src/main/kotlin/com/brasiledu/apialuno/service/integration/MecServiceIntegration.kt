package com.brasiledu.apialuno.service.integration

import com.brasiledu.apialuno.dto.AlunoDTO
import com.brasiledu.apialuno.service.command.AlunoMecCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MecServiceIntegration @Autowired constructor(var alunoMecCommand: AlunoMecCommand) {

    fun enviarInformacaoAluno(aluno: AlunoDTO) {
        println("iniciando envio de dados para o mec")
        enviarAlunoParaMec(aluno)
    }

    private fun enviarAlunoParaMec(aluno: AlunoDTO) {
        alunoMecCommand.run(aluno)
    }

}