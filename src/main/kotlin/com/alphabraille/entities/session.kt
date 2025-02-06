package com.alphabraille.entities


import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "sessions")
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    val person: Person,

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    val device: Device,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    val event: Event
)
