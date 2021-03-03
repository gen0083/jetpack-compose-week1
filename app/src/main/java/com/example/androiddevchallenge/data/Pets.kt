package com.example.androiddevchallenge.data

import kotlin.random.Random

data class Pets(
    val name: String,
    val pictureUrl: String,
    val description: String
)

val RANDOM = Random(System.currentTimeMillis())

fun generateRandomPets(): Pets {
    val chars = ('a'..'z') + ('A'..'Z')
    val name = buildString {
        repeat(RANDOM.nextInt(3, 10)) {
            append(chars[RANDOM.nextInt(0, chars.size)])
        }
    }
    val description = buildString {
        repeat(RANDOM.nextInt(20, 100)) {
            append(chars[RANDOM.nextInt(0, chars.size)])
        }
    }
    return Pets(name, "none", description)
}
