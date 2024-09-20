package com.example.rick_morty.ui.sreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.rick_morty.components.ButtonBack
import com.example.rick_morty.components.TopBar
import com.example.rick_morty.ui.viewModels.DetailViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    id: Int,
    detailViewModel: DetailViewModel = getViewModel()
) {
    val detail by detailViewModel.detail.collectAsState()
    detail.let { detail ->
        Scaffold(
            topBar = {
                TopBar(
                    navigationIcon = { ButtonBack(navController = navController) },
                    title = detail?.name.toString()
                )
            }
        ) {
            Column(
                modifier = Modifier.padding(top = it.calculateTopPadding())
            ) {

                LaunchedEffect(Unit) {
                    detailViewModel.loadData(id)
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        model = detail?.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        border = BorderStroke(2.dp, color = Color.Blue),
                        colors = CardDefaults.cardColors(Color.Transparent)
                    ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                text = "STATUS: "+detail?.status.toString(),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        border = BorderStroke(2.dp, color = Color.LightGray),
                        colors = CardDefaults.cardColors(Color.Transparent)
                    ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                text = "ORIGIN: "+detail?.origin?.name.toString(),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        border = BorderStroke(2.dp, color = Color.Red),
                        colors = CardDefaults.cardColors(Color.Transparent)
                    ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                text = "GENDER: "+detail?.gender.toString(),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        border = BorderStroke(2.dp, color = Color.Yellow),
                        colors = CardDefaults.cardColors(Color.Transparent)
                    ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                text = "SPECIES: "+detail?.species,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                    }
                }
            }
        }
    }
}
