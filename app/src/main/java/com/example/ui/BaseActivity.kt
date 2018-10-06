package com.example.ui

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(gtContentView())
        onViewReady(savedInstanceState, intent)
    }

    abstract fun gtContentView(): Int

    abstract fun onViewReady(savedInstanceState: Bundle?, intent: Intent?)
}