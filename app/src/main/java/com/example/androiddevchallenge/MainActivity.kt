/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.Pets
import com.example.androiddevchallenge.ui.ditail.DetailScreen
import com.example.androiddevchallenge.ui.list.ListScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    
    val viewModel by viewModels<MainViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel, this.onBackPressedDispatcher)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: MainViewModel, onBackPressedDispatcher: OnBackPressedDispatcher) {
    Surface(color = MaterialTheme.colors.background) {
        when (viewModel.screenState) {
            is SelectedScreen.ListScreen   ->
                ListScreen(pets = viewModel.petsList,
                    onItemSelected = viewModel::onItemSelect)
            is SelectedScreen.DetailScreen ->
                DetailScreen(
                    pet = (viewModel.screenState as SelectedScreen.DetailScreen).selected,
                    onBackPressedDispatcher,
                    viewModel::onBackPress
                )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    val vm = MainViewModel()
    MyTheme {
        MyApp(vm, OnBackPressedDispatcher())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    val vm = MainViewModel()
    MyTheme(darkTheme = true) {
        MyApp(vm, OnBackPressedDispatcher())
    }
}

sealed class SelectedScreen {
    object ListScreen : SelectedScreen()
    data class DetailScreen(val selected: Pets) : SelectedScreen()
}
