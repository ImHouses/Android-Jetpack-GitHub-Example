package com.example.jcasas.githubjetpackexample.data

import com.example.jcasas.githubjetpackexample.data.model.GitHubRepository
import com.example.jcasas.githubjetpackexample.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @GET("/repositories")
    fun getRepos(): Call<List<GitHubRepository>>

    @GET("/users/{username}")
    fun getUser(@Path("username") username: String): Call<User>

    @GET("/users/{username}/repos")
    fun getUserRepos(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Call<List<GitHubRepository>>
}