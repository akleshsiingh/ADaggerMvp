package com.example.ui.github

import com.example.di.ActivityScoped
import com.example.network.Api
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class GitHubModule {

    @Binds
    abstract fun getGitHubView(view: GitHubActivity): GitHubView

    @Module
    companion object {

        @Provides
        @JvmStatic
        @ActivityScoped
        fun getRepository(api: Api): IGitHubRepository {
            return GithubRepositoryImpl(api)
        }

    }
}