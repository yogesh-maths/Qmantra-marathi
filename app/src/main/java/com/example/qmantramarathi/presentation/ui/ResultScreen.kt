package com.qmantramarathi.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(
    score: Int,
    totalQuestions: Int,
    onRetry: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Quiz Completed!",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Your Score",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$score / $totalQuestions",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { onRetry() }
        ) {
            Text("Retry Quiz")
        }
    }
}
