package com.example.rick_morty.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.rick_morty.R

@Composable
fun ButtonBack(
    navController: NavController
) {
    IconButton(onClick = { navController.popBackStack()}) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = null
        )

    }
}