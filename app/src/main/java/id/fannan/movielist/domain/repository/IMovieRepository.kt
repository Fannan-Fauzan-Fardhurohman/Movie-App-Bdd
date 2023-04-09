package id.fannan.movielist.domain.repository

import id.fannan.movielist.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    suspend fun getNowPlayingMovie(): Flow<List<Movie>>
}