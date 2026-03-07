package com.example.qmantramarathi.data.api

import com.example.qmantramarathi.domain.model.Question
import retrofit2.http.GET

interface GitHubApiService {
    @GET("quetsions.json")
    suspend fun getQuestions(): List<QuestionDto>
}