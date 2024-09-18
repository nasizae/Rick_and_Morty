package com.example.rick_morty.ui.sreens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
@Preview(showSystemUi = true)
@Composable
fun LocationScreen() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = "Location",
        fontSize = 36.sp,
        textAlign = TextAlign.Center
    )
}