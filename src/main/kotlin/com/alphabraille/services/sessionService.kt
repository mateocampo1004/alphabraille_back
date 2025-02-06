package com.alphabraille.services


import com.alphabraille.entities.Session
import com.alphabraille.repositories.SessionRepository
import org.springframework.stereotype.Service

@Service
class SessionService(private val sessionRepository: SessionRepository) {
    fun findAll(): List<Session> = sessionRepository.findAll()
    fun save(session: Session): Session = sessionRepository.save(session)
}
