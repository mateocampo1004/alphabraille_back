package com.alphabraille.controller

import com.alphabraille.security.JwtUtil
import com.alphabraille.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userService: UserService,
    private val jwtUtil: JwtUtil  // Corregido aquí
) {
    data class AuthRequest(val username: String, val password: String)
    data class AuthResponse(val token: String)

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): AuthResponse {
        val user = userService.authenticate(request.username, request.password)
            ?: throw RuntimeException("Credenciales inválidas")

        val token = jwtUtil.generateToken(user.username)
        return AuthResponse(token)
    }
}
