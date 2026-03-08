package com.example.qmantramarathi.data.api


import retrofit2.http.GET

interface GitHubApiService {
    @GET("https://raw.githubusercontent.com/yogesh-maths/Qmantra-marathi/main/questions.json")
    suspend fun getQuestions(): List<QuestionDto>
}