package com.example.qmantramarathi.data.local
import androidx.room.Entity

import androidx.room.PrimaryKey


@Entity(tableName = "Questions")
data class QuestionEntity(
@PrimaryKey
val id: Int,
val question:String,
val option1: String,
val option2: String,
val option3:String,
val option4: String,
val correctIndex: Int,
val explanation:String
)