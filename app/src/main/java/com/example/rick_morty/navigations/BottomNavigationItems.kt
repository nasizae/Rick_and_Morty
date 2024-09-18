package com.example.rick_morty.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItems(
    val route:String,
    val title:String?=null,
    val icon:ImageVector?=null
) {
    data object Character:BottomNavigationItems(
        route="CharacterScreen",
        title ="character",
        icon= Icons.Outlined.Person
        )

    data object Location:BottomNavigationItems(
        route = "LocationScreen",
        title = "location",
        icon=Icons.Outlined.LocationOn
    )

    data object Episodes:BottomNavigationItems(
        route = "EpisodesScreen",
        title = "episodes",
        icon = Icons.Outlined.AccountBox
    )
}