package com.example.androiddevchallenge.data

import org.junit.Test

class PetsKtTest {
    
    @Test
    fun generateRandomPetsTest() {
        repeat(10) {
            println(generateRandomPets())
        }
    }
}