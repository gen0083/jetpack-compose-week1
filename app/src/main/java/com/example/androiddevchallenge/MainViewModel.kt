package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Pets

class MainViewModel : ViewModel() {
    
    var screenState by mutableStateOf(SelectedScreen.ListScreen)
        private set
    
    var petsList: List<Pets> by mutableStateOf(listOf())
}