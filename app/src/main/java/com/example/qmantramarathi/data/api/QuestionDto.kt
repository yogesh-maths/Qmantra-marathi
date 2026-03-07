package com.example.qmantramarathi.data.api

import org.w3c.dom.Text

data class QuestionDto(
    val text: String,
    val options : List<String>,
    val correctIndex: Int
)