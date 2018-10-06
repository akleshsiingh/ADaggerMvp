package com.example.network.response

import com.squareup.moshi.Json

data class ResponseGithub(

        @Json(name = "total_count")
        val totalCount: Int = 0,

        @Json(name = "incomplete_results")
        val incompleteResults: Boolean = false,

        @Json(name = "items")
        val items: List<User>? = null
)