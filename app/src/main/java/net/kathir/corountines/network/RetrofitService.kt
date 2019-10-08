package net.kathir.corountines.network

import net.kathir.corountines.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}