package com.alphabraille.service

import com.alphabraille.entities.User
import com.alphabraille.repositories.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authenticationManager: AuthenticationManager,
    private val userRepository: UserRepository
) {

    fun authenticate(username: String, password: String): Authentication {
        val authToken = UsernamePasswordAuthenticationToken(username, password)
        return authenticationManager.authenticate(authToken)
    }


}
