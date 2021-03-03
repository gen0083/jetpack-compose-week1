package com.example.androiddevchallenge.ui.ditail

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.data.Pets

@Composable
fun DetailScreen(
    pet: Pets,
    dispatcher: OnBackPressedDispatcher,
    onBackPress: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text("detail screen")
        Text(pet.name, style = MaterialTheme.typography.h3)
        BackKeyHandler(dispatcher = dispatcher, onBackPress = onBackPress)
    }
}

@Composable
fun BackKeyHandler(dispatcher: OnBackPressedDispatcher, onBackPress: () -> Unit) {
    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPress()
            }
        }
    }
    DisposableEffect(key1 = dispatcher, effect = {
        dispatcher.addCallback(backCallback)
        
        onDispose {
            backCallback.remove()
        }
    })
}