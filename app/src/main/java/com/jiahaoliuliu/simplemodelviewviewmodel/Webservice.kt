package com.jiahaoliuliu.simplemodelviewviewmodel

import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice  {

    @GET("/user/{user}")
    suspend fun getUser(@Path("user") userId: String): User
}