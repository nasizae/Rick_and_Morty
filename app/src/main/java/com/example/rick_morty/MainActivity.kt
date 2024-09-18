package com.example.rick_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rick_morty.components.BottomBar
import com.example.rick_morty.navigations.NavGraph
import com.example.rick_morty.ui.theme.Rick_MortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rick_MortyTheme {
                val navController: NavHostController = rememberNavController()
                var buttonVisibility by remember {
                    mutableStateOf(true)
                }

                Scaffold(
                    bottomBar = {
                        if (buttonVisibility) {
                            BottomBar(
                                navController = navController,
                                state = buttonVisibility,
                                modifier = Modifier
                            )
                        }
                    }
                ) {
                    Box(
                        modifier = Modifier.padding(it)
                    ) {
                        NavGraph(navController = navController) { isVisibility ->
                            buttonVisibility = isVisibility
                        }
                    }
                }
            }
        }
    }
}