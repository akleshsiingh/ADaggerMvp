package com.example.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflateView(layout: Int): View {
    return LayoutInflater.from(this.context).inflate(layout, this, false)
}

var View.visible: Boolean
    get() = this.visibility == View.VISIBLE
    set(value) {
        if (value)
            this.visibility = View.VISIBLE
        else
            this.visibility = View.INVISIBLE
    }
