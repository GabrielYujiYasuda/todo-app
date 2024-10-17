package com.example.myapplication.features.feature_task.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.features.feature_main.MainPage
import com.example.myapplication.features.feature_task.domain.use_case.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        setContent {
            MainPage(todoViewModel)
        }
    }
}


@Preview
@Composable
fun MainPagePreview(){
    val todoViewModel = TodoViewModel()

    MainPage(todoViewModel)
}