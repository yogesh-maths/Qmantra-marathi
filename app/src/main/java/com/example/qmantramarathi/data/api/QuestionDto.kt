package com.example.qmantramarathi.data.api



data class QuestionDto(
    val id: Int,
    val question: String,
    val options : List<String>,
    val correctIndex: Int,
    val correctText: String,
    val explanation: String
)