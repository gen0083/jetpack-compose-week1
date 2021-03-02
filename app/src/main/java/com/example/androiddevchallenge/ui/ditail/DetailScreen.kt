package com.example.androiddevchallenge.ui.ditail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.Pets

@Composable
fun DetailScreen(pet: Pets, modifier: Modifier = Modifier) {
    Column {
        Text("detail screen")
        Text(pet.name, style = MaterialTheme.typography.h3)
    }
}

@Composable
@Preview(showSystemUi = true)
fun DetailScreenPreview() {
    DetailScreen(pet = Pets("test", "test", "test"))
}