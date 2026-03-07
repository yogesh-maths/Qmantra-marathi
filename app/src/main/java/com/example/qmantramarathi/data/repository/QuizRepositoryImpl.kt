package com.example.qmantramarathi.data.repository
import com.example.qmantramarathi.domain.repository.QuizRepository
import com.example.qmantramarathi.domain.model.Question

class QuizRepositoryImpl : QuizRepository {



    override suspend fun getQuestions(): List<Question> {

        return listOf(
            Question(
                text = "2 + 2 = ?",
                options = listOf("3","4","5","6"),
                correctIndex = 1,
                explanation = "2 + 2 = 4"
            ),
        Question(
            text = "5 × 3 = ?",
            options = listOf("10","15","20","25"),
            correctIndex = 1,
                    explanation = "5 × 3 = 15"
            )
        )
        }
    }
