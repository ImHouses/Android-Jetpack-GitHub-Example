package com.example.jcasas.githubjetpackexample.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jcasas.githubjetpackexample.data.WebService
import com.example.jcasas.githubjetpackexample.data.model.GitHubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubRepoRepository {

    private val mWebService: WebService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mWebService = retrofit.create(WebService::class.java)
    }

    fun getPublicRepos(): LiveData<List<GitHubRepository>> {
        val mutableLiveData = MutableLiveData<List<GitHubRepository>>()
        mWebService.getRepos()
            .enqueue(object: Callback<List<GitHubRepository>> {
                override fun onFailure(call: Call<List<GitHubRepository>>, t: Throwable) { }

                override fun onResponse(
                    call: Call<List<GitHubRepository>>,
                    response: Response<List<GitHubRepository>>
                ) {
                    mutableLiveData.value = if(response.body() == null) {
                        listOf()
                    } else {
                        response.body()
                    }
                }
            })
        return mutableLiveData
    }
}