package com.alphabraille.security

import com.alphabraille.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("Usuario no encontrado")

        return org.springframework.security.core.userdetails.User(
            user.username,
            user.password,  // ⚡ Aquí va la contraseña encriptada
            emptyList()     // O las autoridades si las tienes configuradas
        )
    }
}
