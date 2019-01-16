package com.example.jcasas.githubjetpackexample.presentation.repositories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jcasas.githubjetpackexample.R
import com.example.jcasas.githubjetpackexample.data.model.GitHubRepository
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoriesAdapter(
    private val repoList: List<GitHubRepository>
) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(repo: GitHubRepository) {
            bindTitle(repo.name)
            view.textDescriptionRepoItem.text = repo.description
            Glide
                .with(view.context)
                .load(repo.owner.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view.imageAvatarRepoItem)
            view.textOwnerNameRepoItem.text = repo.owner.username
        }

        private fun bindTitle(name: String) {
            val characterArray = name.toCharArray()
            for((index) in characterArray.withIndex()) {
                if(index == 0 && characterArray[0].isLetter()) {
                    characterArray[0] = characterArray[0].toString().capitalize().toCharArray()[0]
                }
            }
            view.textNameRepoItem.text = String(characterArray)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.repository_item,
            parent,
            false
        ).apply { isClickable = true })

    override fun getItemCount(): Int  = repoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(repoList[position])
    }
}