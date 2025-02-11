package com.alphabraille.services


import com.alphabraille.entities.User
import com.alphabraille.repositories.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val authenticationManager: AuthenticationManager
) {
    fun findByUsername(username: String): User? = userRepository.findByUsername(username)
    fun save(user: User): User = userRepository.save(user)

    fun authenticate(username: String, password: String): User? {
        return try {
            val authToken = UsernamePasswordAuthenticationToken(username, password)
            val authentication = authenticationManager.authenticate(authToken)
            userRepository.findByUsername(authentication.name)
        } catch (ex: Exception) {
            println("Error de autenticación: ${ex.message}")  // Esto ayudará en la consola
            null  // Si falla la autenticación, devuelve null
        }
    }

}


