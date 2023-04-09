package id.fannan.movielist.data

import id.fannan.movielist.data.remote.MovieRepository
import id.fannan.movielist.data.remote.RemoteDataSource
import id.fannan.movielist.data.remote.network.MovieServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppMovieContainer {
    val remoteDatSource: RemoteDataSource
    val movieRepository: MovieRepository
}

class DefaultAppMovieContainer : AppMovieContainer {
    private val BASE_URL = "https://api.themoviedb.org/3/"

    //    print response json
    private val interceptor: OkHttpClient
        get() {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(interceptor)
        .build()

    private val movieService: MovieServices by lazy {
        retrofit.create(MovieServices::class.java)
    }

    override val remoteDatSource: RemoteDataSource
            by lazy {
                RemoteDataSource(movieService)
            }
    override val movieRepository: MovieRepository
            by lazy {
                MovieRepository(remoteDatSource)
            }

}