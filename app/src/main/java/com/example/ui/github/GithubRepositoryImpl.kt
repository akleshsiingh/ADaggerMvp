package com.example.ui.github


import com.example.network.Api

class GithubRepositoryImpl(private val api: Api) : IGitHubRepository {

    override fun getUsers(username: String) = api.findUSers(username)
}


