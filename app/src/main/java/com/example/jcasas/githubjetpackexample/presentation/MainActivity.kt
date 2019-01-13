package com.example.jcasas.githubjetpackexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.jcasas.githubjetpackexample.R
import com.example.jcasas.githubjetpackexample.presentation.repositories.RepositoriesFragment
import com.example.jcasas.githubjetpackexample.presentation.showuser.ShowUserFragment
import com.example.jcasas.githubjetpackexample.presentation.userrepositories.UserRepositoriesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mFragmentTransaction: FragmentTransaction
    private val repositoriesFragment: RepositoriesFragment = RepositoriesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeFragments()
    }

    private fun initializeFragments() {
        bottomNavigationMain.setOnNavigationItemSelectedListener { item ->
            mFragmentTransaction = supportFragmentManager.beginTransaction()
            when(item.itemId) {
                R.id.action_repositories -> {
                    mFragmentTransaction.replace(R.id.mainFrame, repositoriesFragment)
                }
                R.id.action_user -> {
                    mFragmentTransaction.replace(R.id.mainFrame, UserRepositoriesFragment())
                }
                else -> {
                    mFragmentTransaction.replace(R.id.mainFrame, ShowUserFragment())
                }
            }
            mFragmentTransaction.commit()
            return@setOnNavigationItemSelectedListener true
        }
        /* We first load repositories. */
        bottomNavigationMain.selectedItemId = R.id.action_repositories
    }
}
