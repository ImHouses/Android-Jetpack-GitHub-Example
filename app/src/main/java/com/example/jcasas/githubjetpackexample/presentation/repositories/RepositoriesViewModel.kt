package com.example.jcasas.githubjetpackexample.presentation.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jcasas.githubjetpackexample.data.model.GitHubRepository
import com.example.jcasas.githubjetpackexample.data.source.GithubRepoRepository

class RepositoriesViewModel : ViewModel() {

    fun getRepos(): LiveData<List<GitHubRepository>> = GithubRepoRepository.getPublicRepos()
}