package com.example.ui.github


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GitHubPresenter @Inject constructor(private val view: GitHubView, private val repo: IGitHubRepository) {

    val source = PublishProcessor.create<String>()
    init {
        val d = source
                .skip(1)
                .debounce(200,TimeUnit.MILLISECONDS)
                .switchMap { username -> repo.getUsers(username).toFlowable() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it == null) {
                        view.onError("something went wrong")
                        return@subscribe
                    }
                    if (it.items == null)
                        view.noUserFound()
                    else view.onUserLoaded(it.items)
                }) { view.onError(it.localizedMessage) }
    }

    fun getUsers(username: String) = source.onNext(username)
}

