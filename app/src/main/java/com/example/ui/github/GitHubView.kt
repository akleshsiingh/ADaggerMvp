package com.example.ui.github


import com.example.network.response.User

interface GitHubView {

    fun onUserLoaded(usersList: List<User>)
    fun noUserFound()
    fun onError(msg: String)
}