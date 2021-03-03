package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NoPhotography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Pets
import com.example.androiddevchallenge.data.generateRandomPets

@Composable
fun ListScreen(pets: List<Pets>, onItemSelected: (Pets) -> Unit) {
    LazyColumn {
        items(pets) { pet ->
            PetsItem(pet = pet, onItemSelected = onItemSelected)
            Divider(color = Color.Black)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ListScreenPreview() {
    val pets = List(3) { generateRandomPets() }
    ListScreen(pets) {}
}

@Composable
fun PetsItem(pet: Pets, onItemSelected: (Pets) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .clickable { onItemSelected(pet) },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            imageVector = Icons.Default.NoPhotography,
            contentDescription = "no image",
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = pet.name,
                style = MaterialTheme.typography.h3,
            )
        }
    }
}

@Composable
@Preview
fun PetsItemPreview() {
    val pet = generateRandomPets()
    PetsItem(pet = pet) {}
}