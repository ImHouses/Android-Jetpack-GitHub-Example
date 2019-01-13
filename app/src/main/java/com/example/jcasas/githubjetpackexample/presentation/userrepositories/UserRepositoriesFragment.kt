package com.example.jcasas.githubjetpackexample.presentation.userrepositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jcasas.githubjetpackexample.R

class UserRepositoriesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            LayoutInflater.from(container?.context).inflate(R.layout.fragment_user_repos, container, false)
}