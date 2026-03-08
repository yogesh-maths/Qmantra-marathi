package com.example.qmantramarathi.data.repository
import com.example.qmantramarathi.data.api.RetrofitClient
import com.example.qmantramarathi.domain.repository.QuizRepository
import com.example.qmantramarathi.domain.model.Question

class QuizRepositoryImpl : QuizRepository {


    override suspend fun getQuestions(): List<Question> {

        return RetrofitClient.api.getQuestions().map {

            Question(
                id = it.id,
                question = it.question,
                options = it.options,
                correctIndex = it.correctIndex,
                explanation = it.explanation

            )
        }

    }
}

