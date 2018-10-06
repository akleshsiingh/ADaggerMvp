package com.example.ui.github

import com.example.network.response.ResponseGithub
import com.example.network.response.User
import io.reactivex.Single


interface IGitHubRepository {

    fun getUsers(username: String): Single<ResponseGithub>

}