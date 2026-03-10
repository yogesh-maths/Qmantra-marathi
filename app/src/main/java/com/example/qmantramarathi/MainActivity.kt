package com.example.qmantramarathi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.qmantramarathi.data.api.RetrofitClient
import com.example.qmantramarathi.data.local.AppDatabase
import com.example.qmantramarathi.data.repository.QuizRepositoryImpl
import com.example.qmantramarathi.domain.usecase.GetQuestionsUseCase
import com.example.qmantramarathi.presentation.ui.QuizScreen
import com.example.qmantramarathi.presentation.viewmodel.QuizViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create databasse
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "quiz_db"

        ).build()
        //Create Repository

        val repository = QuizRepositoryImpl(
            api = RetrofitClient.api,
            dao=db.questionDao()
        )
        val useCase = GetQuestionsUseCase(repository)
        val viewModel = QuizViewModel(useCase)



        setContent {
            QuizScreen(viewModel)
        }
    }
}