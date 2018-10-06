package com.example.ui.github

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.githubusers.R
import com.example.network.response.User
import com.example.ui.BaseActivity
import com.example.ui.visible
import kotlinx.android.synthetic.main.activity_github.*
import java.lang.StringBuilder
import javax.inject.Inject

class GitHubActivity : BaseActivity(), GitHubView {

    @Inject
    lateinit var presenter: GitHubPresenter

    val adapterUsers = AdapterUsers()
    override fun gtContentView() = R.layout.activity_github

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {
        tvUsername.addTextChangedListener(TextWatcher())

        list.apply {
            layoutManager = LinearLayoutManager(this@GitHubActivity)
            adapter = adapterUsers
        }
    }

    inner class TextWatcher : android.text.TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            presenter.getUsers(tvUsername.text.toString().trim())
        }

    }

    override fun onUserLoaded(usersList: List<User>) {
        val stringBuilder = StringBuilder()
        for (i in usersList)
            stringBuilder.append("${i.login},\n")
        tvList.text = stringBuilder.toString()
        tvList.visible = false
        list.visible = true
        adapterUsers.userList = usersList

    }

    override fun noUserFound() {
        tvList.visible = true
        list.visible = false
        tvList.text = getString(R.string.no_users)
    }

    override fun onError(msg: String) {
        tvList.visible = true
        list.visible = false
        tvList.text = msg
    }
}

