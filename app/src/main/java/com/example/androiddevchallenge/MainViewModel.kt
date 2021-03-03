package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Pets
import com.example.androiddevchallenge.data.generateRandomPets

class MainViewModel : ViewModel() {
    
    var screenState: SelectedScreen by mutableStateOf(SelectedScreen.ListScreen)
        private set
    
    var petsList: List<Pets> by mutableStateOf(
        List(13) { generateRandomPets() }
    )
    
    fun onItemSelect(pet: Pets) {
        screenState = SelectedScreen.DetailScreen(pet)
    }
    
    fun onBackPress() {
        screenState = SelectedScreen.ListScreen
    }
}