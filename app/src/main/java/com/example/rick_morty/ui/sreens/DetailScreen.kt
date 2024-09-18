package com.example.rick_morty.ui.sreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.rick_morty.ui.viewModels.DetailViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    id: Int,
    detailViewModel: DetailViewModel = getViewModel()
) {

    val detail by detailViewModel.detail.collectAsState()

    LaunchedEffect(Unit) {
        detailViewModel.loadData(id)
    }

    detail.let { detail ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = detail?.image,
                contentDescription = null
            )
            Text(text =detail?.name.toString() )
            Text(text = detail?.status.toString())
            Text(text = detail?.species.toString())
        }
    }

}
