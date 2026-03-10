package com.example.qmantramarathi.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.qmantramarathi.presentation.viewmodel.QuizViewModel
import com.qmantramarathi.presentation.ui.ResultScreen


@Composable

fun QuizScreen(viewModel: QuizViewModel) {

    val state = viewModel.uiState

    if (state.questions.isEmpty()) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (state.isFinished) {

        ResultScreen(
            score = state.score,
            totalQuestions = state.questions.size,
            onRetry = { viewModel.retryQuiz() }
        )

    } else {

        val question = state.questions.getOrNull(state.currentIndex)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            question?.let {
                Text(text = it.question)
                Spacer(modifier = Modifier.height(24.dp))
                it.options.forEachIndexed { index, option ->
                    Button(
                        onClick = { viewModel.submitAnswer(index) },
                        enabled = !state.showExplanation,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Text(option)
                    }
                }

                if (state.showExplanation) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Explanation:${it.explanation}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(

                        onClick = { viewModel.nextQuestion() }
                    ) {
                        Text("Next Question")


                    }


                }
            }
        }
    }
}











