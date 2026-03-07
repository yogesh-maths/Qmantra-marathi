package com.example.qmantramarathi.domain.repository



import com.example.qmantramarathi.domain.model.Question

interface QuizRepository {

    suspend fun getQuestions(): List<Question>

}