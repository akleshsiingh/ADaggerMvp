package com.example

import com.example.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MvpApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().bindApplication(this).build()
        appComponent.inject(this) // not necessary
        return appComponent
    }
}