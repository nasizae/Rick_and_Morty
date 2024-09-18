package com.example.rick_morty.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rick_morty.ui.sreens.CharactersScreen
import com.example.rick_morty.ui.sreens.DetailScreen
import com.example.rick_morty.ui.sreens.EpisodesScreen
import com.example.rick_morty.ui.sreens.LocationScreen

@Composable
fun NavGraph(navController: NavHostController, onBottomBarVisibilityChanged: (Boolean) -> Unit) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItems.Character.route
    ) {
        composable(BottomNavigationItems.Character.route) {
            onBottomBarVisibilityChanged(true)
            CharactersScreen(navController)
        }
        composable(BottomNavigationItems.Location.route) {
            onBottomBarVisibilityChanged(true)
            LocationScreen()
        }
        composable(BottomNavigationItems.Episodes.route) {
            onBottomBarVisibilityChanged(true)
            EpisodesScreen()
        }
        composable(
            "detailScreen/{id}",
            arguments = listOf(navArgument("id"){type = NavType.IntType})
        ) {
            onBottomBarVisibilityChanged(false)
            val id= it.arguments?.getInt("id")
            DetailScreen(id = id?:0)
        }
    }
}