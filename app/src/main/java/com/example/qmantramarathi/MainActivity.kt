package com.example.qmantramarathi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.qmantramarathi.data.repository.QuizRepositoryImpl
import com.example.qmantramarathi.domain.usecase.GetQuestionsUseCase
import com.example.qmantramarathi.presentation.ui.QuizScreen
import com.example.qmantramarathi.presentation.viewmodel.QuizViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = QuizRepositoryImpl()
        val useCase = GetQuestionsUseCase(repository)
        val viewModel = QuizViewModel(useCase)

        setContent {
            QuizScreen(viewModel)
        }
    }
}