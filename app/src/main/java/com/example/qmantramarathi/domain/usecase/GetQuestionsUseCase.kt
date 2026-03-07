package com.example.qmantramarathi.domain.usecase

import com.example.qmantramarathi.domain.repository.QuizRepository
import com.example.qmantramarathi.domain.model.Question

class GetQuestionsUseCase(
    private val repository: QuizRepository
) {

    suspend operator fun invoke(): List<Question>{
        return repository.getQuestions()
    }

}

