package com.example.jcasas.githubjetpackexample.presentation.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jcasas.githubjetpackexample.R
import com.example.jcasas.githubjetpackexample.data.model.GitHubRepository
import com.example.jcasas.githubjetpackexample.presentation.repositories.adapter.RepositoriesAdapter
import kotlinx.android.synthetic.main.fragment_repositories.*

class RepositoriesFragment : Fragment() {

    private lateinit var mViewModel: RepositoriesViewModel
    private lateinit var mRepoAdapter: RepositoriesAdapter
    private val mRepoList: MutableList<GitHubRepository> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = LayoutInflater.from(container?.context).inflate(
        R.layout.fragment_repositories,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProviders.of(this)[RepositoriesViewModel::class.java]
        mRepoAdapter = RepositoriesAdapter(mRepoList)
        rvRepos.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@RepositoriesFragment.activity)
            adapter = mRepoAdapter
        }
        mViewModel.getRepos().observe(this, Observer { repos ->
            if(repos.isNullOrEmpty()) {
                textErrorRepositories.visibility = View.VISIBLE
                reposProgressBar.visibility = View.GONE
            } else {
                reposProgressBar.visibility = View.GONE
                mRepoList.clear()
                mRepoList.addAll(repos)
                mRepoAdapter.notifyDataSetChanged()
            }
        })
    }

}