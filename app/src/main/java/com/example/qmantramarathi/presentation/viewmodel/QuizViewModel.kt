package com.example.qmantramarathi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qmantramarathi.domain.usecase.GetQuestionsUseCase
import com.example.qmantramarathi.presentation.state.QuizUiState
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class QuizViewModel(
    private val getQuestionsUseCase: GetQuestionsUseCase
) : ViewModel() {

    var uiState by mutableStateOf(QuizUiState())
        private set

    init {
        loadQuestions()
    }

    private fun loadQuestions() {

        viewModelScope.launch {

            val questions = getQuestionsUseCase()

            uiState = uiState.copy(
                questions = questions
            )
        }

    }

    fun submitAnswer(selectedIndex: Int) {

        val questions = uiState.questions
        val currentIndex = uiState.currentIndex
        val question = questions[currentIndex]


        val newScore =
            if (selectedIndex == question.correctIndex)
                uiState.score + 1
            else
                uiState.score
        uiState = uiState.copy(
            score = newScore,
            selectedAnswer = selectedIndex,
            showExplanation = true
        )
    }



    fun nextQuestion() {

        val nextIndex = uiState.currentIndex + 1
        val finished = nextIndex >= uiState.questions.size

        uiState = uiState.copy(
            currentIndex = nextIndex,
            isFinished = finished,
            selectedAnswer = null,
            showExplanation = false
        )
    }

    fun retryQuiz() {

        uiState = uiState.copy(
            currentIndex = 0,
            score = 0,
            isFinished = false
        )

    }
}



