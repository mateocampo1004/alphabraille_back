package com.alphabraille

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AlphabrailleApplication

fun main(args: Array<String>) {
    runApplication<AlphabrailleApplication>(*args)
}
