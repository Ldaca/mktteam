
package com.ldaca.app.ready.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.ldaca.app.ready.data.domain.Post
import com.ldaca.app.ready.data.domain.Repo
import com.ldaca.app.ready.data.server.Page
import com.ldaca.app.ready.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor (private val repo: Repo) : ViewModel() {

    private val isLoggedIn = MutableLiveData<Boolean>()
    private var accessToken = ""
    private var pageToken = ""
    var pageId = "1419679808278917"
    private val _pageList = MutableLiveData<List<Page>>()
    val pageList: LiveData<List<Page>> get() = _pageList

    fun onLoggedIn(isLogin: Boolean) {
        isLoggedIn.value = isLogin
    }

    fun setAccessToken(token: String) {
        accessToken = token
    }

    fun onFetchPostsList(provider: String) = isLoggedIn.distinctUntilChanged().switchMap { onLogin ->
            liveData(Dispatchers.IO) {
                if (onLogin) {
                    emit(Resource.Loading())
                    try {
                        val pages = repo.getPages(accessToken)
                        if (pages.isNotEmpty()) {
                            for (page in pages) {
                                if (page.idPage == pageId) {

                                }
                            }
                            emit(Resource.Success(repo.getPostsList(accessToken, provider, pageId)))
                        }
                        emit(Resource.Success(repo.getPostsList(accessToken, provider, pageId)))
                    } catch (e: Exception) {
                        emit(Resource.Failure(e))
                    }
                } else {
                    emit(Resource.Success(emptyList<Post>()))
                }
            }
        }


    fun getPagesList(){
        viewModelScope.launch {
            _pageList.value = repo.getPages(accessToken)
        }
    }

    fun onSavePost(provider: String, post: Post) = isLoggedIn.distinctUntilChanged().switchMap { onLogin ->
        liveData(Dispatchers.IO) {
            if (onLogin) {
                emit(Resource.Loading())
                try {
                    repo.savePost(post)
                    emit(Resource.Success(repo.getPostsList(accessToken, provider, pageId)))
                } catch (e: Exception) {
                    emit(Resource.Failure(e))
                }
            } else {
                emit(Resource.Success(emptyList<Post>()))
            }
        }
    }
}