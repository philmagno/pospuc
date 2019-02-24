package com.brasiledu.apialuno.service.command

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import com.amazonaws.services.sqs.model.SendMessageRequest
import com.brasiledu.apialuno.dto.AlunoDTO
import com.brasiledu.apialuno.service.integration.MecServices
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class AlunoMecCommand(){

    @Autowired
    lateinit var mecServices: MecServices

    companion object {
        val SQS_NAME = "aluno_sqs_reprocess"
    }

    fun run(aluno: AlunoDTO) {
        try {
            mecServices.enviarDadosDeAluno(aluno)
        }catch (e: Exception){
            val awsCreds = BasicAWSCredentials("AKIAIGKBQVRGA5HPJPTA", "qBj/JdS5paHtkJrMQdORVeYTWKZz3CWSEPsjPOIR")
            var sqs = AmazonSQSClientBuilder.standard().withCredentials(AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.US_EAST_1).build()
            val mapper = ObjectMapper()
            val jsonInString = mapper.writeValueAsString(aluno)
            sqs.sendMessage(SendMessageRequest(SQS_NAME, jsonInString))
        }
    }

}