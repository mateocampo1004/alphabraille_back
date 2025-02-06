package com.alphabraille.controller

import com.alphabraille.security.JwtUtil
import com.alphabraille.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userService: UserService,
    private val JwtUtil: JwtUtil
) {
    data class AuthRequest(val username: String, val password: String)
    data class AuthResponse(val token: String)

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): AuthResponse {
        val user = userService.authenticate(request.username, request.password)
        val token = JwtUtil.generateToken(user?.username ?: "")
        return AuthResponse(token)
    }

}
