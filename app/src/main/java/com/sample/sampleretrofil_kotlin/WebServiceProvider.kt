package com.sample.sampleretrofil_kotlin

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


/**
 * Created by Shivam Jaiswal on 22/03/18.
 */
interface WebServiceProvider {

    companion object {

        private const val BASE_URL = "http://www.omdbapi.com/"

        private val okHttpClient = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectionPool(ConnectionPool(3, 40, TimeUnit.SECONDS))
                .retryOnConnectionFailure(true)
                //add below line only if you want to log you API request (OPTIONAL)
                .addInterceptor(HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE })
                .build()

        var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }


    /**
     * There are many annotations as @Query parameter like @Path
     *  * @see <a href="https://square.github.io/retrofit/">Square's HTTP client for Android website</a>
     */


    /**
     * @param t
     * @param Season
     * @param apikey
     *
     * will be append in url
     */
    @GET("http://www.omdbapi.com/")
    fun getEpisodes(@Query("t") showName: String,
                    @Query("Season") season: String,
                    @Query("apikey") apikey: String): Single<Episodes>


}