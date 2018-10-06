package com.example.di.module

import com.example.di.ActivityScoped
import com.example.ui.github.GitHubActivity
import com.example.ui.github.GitHubModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [GitHubModule::class])
    abstract fun contributeGitHubActivity(): GitHubActivity
}