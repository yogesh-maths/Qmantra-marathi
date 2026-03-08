package com.example.qmantramarathi.data.api

import androidx.compose.ui.input.pointer.PointerId
import com.example.qmantramarathi.domain.model.Question
import org.w3c.dom.Text


data class QuestionDto(
    val id: Int,
    val question: String,
    val options : List<String>,
    val correctIndex: Int,
    val correctText: String,
    val explanation: String
)