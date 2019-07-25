package com.codemobiles.myfirebase.test

import com.codemobiles.myfirebase.test.beans.Json1Bean
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://jsonplaceholder.typicode.com/users

interface HttpClientFeed {
//    @GET("/adhoc/youtubes/index_new.php/")
//    fun feed(@Query("type") type:String): Call<YoutubeBean>

    @GET("/photos")
    fun feedType(): Call<List<Json1Bean>>
//    fun feed(@Query("type") type:String): Call<Json1Bean>

    companion object{
        val BASE_URL = "https://jsonplaceholder.typicode.com"
//        val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun create() : HttpClientFeed {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(HttpClientFeed::class.java)
        }
    }
}