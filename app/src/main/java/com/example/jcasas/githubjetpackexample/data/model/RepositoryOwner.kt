package com.example.jcasas.githubjetpackexample.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryOwner(
    @SerializedName("login") val username: String,
    val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String
)