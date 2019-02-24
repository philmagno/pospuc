package com.brasiledu.apialuno.service

import com.brasiledu.apialuno.model.Usuario
import com.brasiledu.apialuno.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService @Autowired constructor(var usuarioRepository: UsuarioRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(nomeUsuario: String): UserDetails {
        val usuario = usuarioRepository.encontrarUsuarioPeloLogin(nomeUsuario)
        if(usuario == null)
            throw UsernameNotFoundException("Usuário " + nomeUsuario + " não encontrado !")

        return User(usuario.login, encoder().encode(usuario.senha), getGrantedAuthorities(usuario))
    }

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    private fun getGrantedAuthorities(usuario: Usuario): Collection<GrantedAuthority> {
        var authorities = mutableListOf<GrantedAuthority>()

        for (role in usuario.role.split(",")) {
            authorities.add(GrantedAuthority {role})
        }

        return authorities
    }

    fun save(usuario: Usuario){
        usuarioRepository.save(usuario)
    }

    fun recuperarUsuario(userId: Long){
        usuarioRepository.findById(userId)
    }

    fun list(): MutableIterable<Usuario> {
        for (usuario in usuarioRepository.findAll()) {
            println(usuario)
        }
        return usuarioRepository.findAll()
    }
}