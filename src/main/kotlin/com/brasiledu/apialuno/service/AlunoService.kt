package com.brasiledu.apialuno.service

import com.brasiledu.apialuno.dto.AlunoDTO
import com.brasiledu.apialuno.model.Aluno
import com.brasiledu.apialuno.model.Usuario
import com.brasiledu.apialuno.repository.AlunoRepository
import com.brasiledu.apialuno.repository.UsuarioRepository
import com.brasiledu.apialuno.service.integration.MecServiceIntegration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AlunoService @Autowired constructor(var alunoRepository: AlunoRepository,
                                          var usuarioRepository: UsuarioRepository,
                                          var mecServiceIntegration: MecServiceIntegration) {

    fun save(aluno: AlunoDTO){
        persistirAluno(aluno)
        mecServiceIntegration.enviarInformacaoAluno(aluno)
    }

    private fun persistirAluno(aluno: AlunoDTO) {
        var usuario = Usuario(login = aluno.login!!)
        //usuarioRepository.save(usuario)

        var aluno = Aluno(ra = aluno.ra!!, usuario = usuario)
        alunoRepository.save(aluno)
    }

    fun list(): MutableIterable<Aluno> = alunoRepository.findAll()

    fun consultarDadosPessoais(userId: Long) = alunoRepository.findById(userId)
}