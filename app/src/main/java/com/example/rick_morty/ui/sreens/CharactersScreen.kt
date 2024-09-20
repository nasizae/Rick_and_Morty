package com.example.rick_morty.ui.sreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.domain.models.Result
import com.example.rick_morty.R
import com.example.rick_morty.components.TopBar
import com.example.rick_morty.ui.viewModels.CharacterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CharactersScreen(
    navController: NavController,
    characterViewModel: CharacterViewModel = getViewModel(),
) {
    val characterItems = characterViewModel.characters.collectAsLazyPagingItems()

    Scaffold(
        topBar = { TopBar(title = "Character") }
    ) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize()
            ) {
                items(characterItems.itemSnapshotList.items) { character ->
                    character.let {
                        ItemListBranch(character = it, navController)
                    }
                }
                when {
                    characterItems.loadState.append is LoadState.Loading -> {
                        item {
                            Text(
                                text = "Loading...", modifier = Modifier.padding(16.dp),
                                fontSize = 40.sp
                            )
                        }
                    }

                    characterItems.loadState.append is LoadState.Error -> {
                        item {
                            Text(text = "Error loading data.", modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemListBranch(
    character: Result,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { navController.navigate("detailScreen/${character.id}") },
        colors = CardDefaults.cardColors(colorResource(id = R.color.white)),
        elevation = CardDefaults.elevatedCardElevation(16.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            model = character.image,
            contentDescription = character.name,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 6.dp),
            text = character.name ?: "",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 6.dp),
            text = ("Status: " + character.status) ?: "",
            fontSize = 14.sp,
        )
    }
}