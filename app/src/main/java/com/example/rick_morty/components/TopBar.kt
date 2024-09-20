package com.example.rick_morty.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.rick_morty.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navigationIcon: (@Composable () -> Unit)? = null,
    title: String,
) {
    Row {
        CenterAlignedTopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            navigationIcon = { navigationIcon?.invoke() },
            title = {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black)
                )
            },
        )
    }
}