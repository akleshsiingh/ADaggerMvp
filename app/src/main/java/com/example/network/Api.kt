package com.example.network


import com.example.network.response.ResponseGithub
import com.example.network.response.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/search/users")
    fun findUSers(@Query("q") name: String):Single<ResponseGithub>
}