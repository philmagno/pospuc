package com.brasiledu.apialuno

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity

@SpringBootApplication
class ApiAlunoApplication


fun main(args: Array<String>) {
	runApplication<ApiAlunoApplication>(*args)
}

