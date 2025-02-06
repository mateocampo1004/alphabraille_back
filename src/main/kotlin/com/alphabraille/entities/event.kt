package com.alphabraille.entities


import jakarta.persistence.*

@Entity
@Table(name = "events")
data class Event(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val enteredCharacter: String,

    val timeByCharacter: Long
)
