package com.example.jcasas.githubjetpackexample.data.model

import com.google.gson.annotations.SerializedName

data class GitHubRepository(
    val id: Int,
    val name: String,
    val private: Boolean,
    @SerializedName("html_url") val url: String,
    val description: String,
    val owner: RepositoryOwner
)