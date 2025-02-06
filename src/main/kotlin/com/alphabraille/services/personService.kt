package com.alphabraille.services


import com.alphabraille.entities.Person
import com.alphabraille.repositories.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository) {
    fun findAll(): List<Person> = personRepository.findAll()
    fun save(person: Person): Person = personRepository.save(person)
}
