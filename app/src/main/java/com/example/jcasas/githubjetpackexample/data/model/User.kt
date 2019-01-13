package com.example.jcasas.githubjetpackexample.data.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    @SerializedName("login") val username: String,
    val name: String,
    val location: String,
    @SerializedName("public_repos") val publicReposNumber: Int,
    @SerializedName("public_gists") val publicGistsNumber: Int,
    @SerializedName("followers") val followersNumber: Int,
    @SerializedName("following") val followingNumber: Int,
    @SerializedName("created_at") val userSince: String
)