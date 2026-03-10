package com.example.qmantramarathi.data.repository
import com.example.qmantramarathi.data.api.GitHubApiService
import com.example.qmantramarathi.data.mapper.toEntity
import com.example.qmantramarathi.data.local.QuestionDao
import com.example.qmantramarathi.data.mapper.toDomain
import com.example.qmantramarathi.domain.model.Question
import com.example.qmantramarathi.domain.repository.QuizRepository

class QuizRepositoryImpl (
    private val api: GitHubApiService,
    private val dao: QuestionDao
    ) : QuizRepository {


        override suspend fun getQuestions(): List<Question> {
            return try {
                val remote = api.getQuestions()
                dao.insertQuestions(remote.map { it.toEntity() })
                remote.map{it.toDomain()}
            }catch (e: Exception){
                dao.getQuestions().map{it.toDomain()}
            }
        }

        }





