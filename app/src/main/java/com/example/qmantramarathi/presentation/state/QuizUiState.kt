package com.example.qmantramarathi.presentation.state
import com.example.qmantramarathi.domain.model.Question
data class QuizUiState(
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val score: Int = 0,
    val isFinished: Boolean = false,
    val selectedAnswer: Int? = null,
    val showExplanation: Boolean = false
)