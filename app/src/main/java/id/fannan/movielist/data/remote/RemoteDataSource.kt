package id.fannan.movielist.data.remote

import android.util.Log
import id.fannan.movielist.data.remote.network.MovieServices
import id.fannan.movielist.data.remote.response.toListMovie
import id.fannan.movielist.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(
    private val movieService: MovieServices
) {
    suspend fun getNowPlayingMovie() = flow<List<Movie>> {
        movieService.getNowPlaying().toListMovie().let {
            emit(it)
        }
    }.catch {
        Log.d("RemoteDataSource", "getNowPlayingMovie:failed = ${it.message}")
    }.flowOn(Dispatchers.IO)
}