package com.example.network.response

import javax.annotation.Generated
import com.squareup.moshi.Json

@Generated("com.robohorse.robopojogenerator")
data class User(

	@Json(name="score")
	val score: Double? = null,

	@Json(name="avatar_url")
	val avatarUrl: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="login")
	val login: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="gravatar_id")
	val gravatarId: String? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="node_id")
	val nodeId: String? = null
)