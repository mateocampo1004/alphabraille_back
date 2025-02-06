package com.alphabraille.entities

import jakarta.persistence.*

@Entity
@Table(name = "persons")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val fullname: String,

    val age: Int,

    val disabilityLevel: String,

    val status: String
)
