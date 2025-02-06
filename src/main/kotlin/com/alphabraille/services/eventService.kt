package com.alphabraille.services


import com.alphabraille.entities.Event
import com.alphabraille.repositories.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(private val eventRepository: EventRepository) {
    fun findAll(): List<Event> = eventRepository.findAll()
    fun save(event: Event): Event = eventRepository.save(event)
}
