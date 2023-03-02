package com.example.githubsearchwithroom.data

class BookmarkedReposRepository(
    private val dao: GitHubRepoDao
) {
    suspend fun insertBookmarkedRepo(repo: GitHubRepo) = dao.insert(repo)
    suspend fun deleteBookmarkedRepo(repo: GitHubRepo) = dao.delete(repo)
}