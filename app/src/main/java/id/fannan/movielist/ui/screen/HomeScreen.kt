package id.fannan.movielist.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import id.fannan.movielist.ui.MovieViewModel

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    viewModel: MovieViewModel = viewModel(factory = MovieViewModel.Factory)
) {
    val movies by viewModel.movies.collectAsState(arrayListOf())


    var isGrid by remember { mutableStateOf(false) }

    var keyword by remember {
        mutableStateOf("")
    }

    LaunchedEffect("") {
        viewModel.getMovies()
    }
    LaunchedEffect(keyword) {
        viewModel.searchMovie(keyword)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { contentPadding ->
        MovieGridScreen(contentPadding, movies)
    }
}