package id.fannan.movielist.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.fannan.MovieApplication
import id.fannan.movielist.data.remote.MovieRepository
import id.fannan.movielist.domain.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MovieViewModel constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val _movies = MutableStateFlow(emptyList<Movie>())
    val movies: StateFlow<List<Movie>> get() = _movies

    private val currentMovie = mutableStateListOf<Movie>()
    fun getMovies() {
        viewModelScope.launch {
            movieRepository.getNowPlayingMovie().collect {
                currentMovie.clear()
                currentMovie.addAll(it)
                _movies.value = currentMovie
            }
        }
    }

    fun searchMovie(keyword: String) {
        _movies.value = currentMovie.filter { movie ->
            movie.title.contains(keyword, true) || movie.description.contains(keyword, true)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as MovieApplication
                val repository = application.appMovieContainer.movieRepository
                MovieViewModel(
                    repository
                )
            }
        }
    }
}