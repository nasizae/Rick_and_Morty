package com.example.rick_morty.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.models.Result
import com.example.domain.repository.RickAndMortyRepository

class CharacterPagingSource(
    private val apiService: RickAndMortyRepository
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { pos ->
            state.closestPageToPosition(pos)?.prevKey?.plus(1) ?: 1
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page = params.key ?: 1
        Log.d("PagingSource", "Loading page: $page")
        return try {
            val response = apiService.getCharacters(page)
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}