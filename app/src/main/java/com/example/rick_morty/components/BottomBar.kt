package com.example.rick_morty.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rick_morty.navigations.BottomNavigationItems

@Composable
fun BottomBar(
    navController: NavHostController,
    state: Boolean,
    modifier: Modifier
) {
    val screens = listOf(
        BottomNavigationItems.Character,
        BottomNavigationItems.Location,
        BottomNavigationItems.Episodes,
    )

    NavigationBar(modifier = modifier, containerColor = Color.LightGray) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screens ->
            NavigationBarItem(
                selected = currentRoute == screens.route,
                onClick = {
                    navController.navigate(screens.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState=true
                        }
                        launchSingleTop=true
                        restoreState=true
                    }
                },
                colors = NavigationBarItemDefaults.colors(),
                icon = {
                    Icon(imageVector = screens.icon!!, contentDescription = "")
                })

        }
    }
}