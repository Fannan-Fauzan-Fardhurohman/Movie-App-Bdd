package id.fannan

import android.app.Application
import id.fannan.movielist.data.AppMovieContainer
import id.fannan.movielist.data.DefaultAppMovieContainer

class MovieApplication : Application() {
    lateinit var appMovieContainer: AppMovieContainer
    override fun onCreate() {
        super.onCreate()
        appMovieContainer = DefaultAppMovieContainer()
    }


}