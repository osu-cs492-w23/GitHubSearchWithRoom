package com.example.githubsearchwithroom.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.githubsearchwithroom.data.AppDatabase
import com.example.githubsearchwithroom.data.BookmarkedReposRepository
import com.example.githubsearchwithroom.data.GitHubRepo
import kotlinx.coroutines.launch

class BookmarkedReposViewModel(application: Application): AndroidViewModel(application) {
    private val repository = BookmarkedReposRepository(
        AppDatabase.getInstance(application).gitHubRepoDao()
    )

    val bookmarkedRepos = repository.getAllBookmarkedRepos().asLiveData()

    fun addBookmarkedRepo(repo: GitHubRepo) {
        viewModelScope.launch {
            repository.insertBookmarkedRepo(repo)
        }
    }

    fun removeBookmarkedRepo(repo: GitHubRepo) {
        viewModelScope.launch {
            repository.deleteBookmarkedRepo(repo)
        }
    }

    fun getBookmarkedRepoByName(name: String) =
        repository.getBookmarkedRepoByName(name).asLiveData()
}