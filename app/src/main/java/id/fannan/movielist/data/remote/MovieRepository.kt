package id.fannan.movielist.data.remote

import id.fannan.movielist.domain.model.Movie
import id.fannan.movielist.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val remoteDataSource: RemoteDataSource
) : IMovieRepository {
    override suspend fun getNowPlayingMovie(): Flow<List<Movie>> =
        remoteDataSource.getNowPlayingMovie()

}