package com.example.qmantramarathi.data.mapper

import com.example.qmantramarathi.data.api.QuestionDto
import com.example.qmantramarathi.data.local.QuestionEntity
import com.example.qmantramarathi.domain.model.Question


fun QuestionDto.toEntity(): QuestionEntity {
    return QuestionEntity(
        id = id,
        question = question,
        option1 = options[0],
        option2 = options[1],
        option3 = options[2],
        option4 = options[3],
        correctIndex = correctIndex,
        explanation = explanation

    )
}
fun QuestionDto.toDomain(): Question {
    return Question(
        id = id,
        question = question,
        options = options,
        correctIndex = correctIndex,
        explanation = explanation,
    )
}
fun QuestionEntity.toDomain(): Question{
    return Question(

        id = id,
        question = question,
        options = listOf(option1,option2,option3,option4),
        correctIndex = correctIndex,
        explanation = explanation,
    )

}