package id.fannan.movielist.data.remote.network

import id.fannan.movielist.data.remote.response.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {
    //    https://api.themoviedb.org/3/
    //    movie/now_playing?api_key=<<api_key>>&language=en-US&page=1
    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String = "ee501bd7aaa4fd01bebd96eaf379ff14",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ):NowPlayingResponse
}