/*
 * Created by Luis Davila on 5/05/21, 7:23 p. m.
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 5/05/21, 7:23 p. m.
 */

package com.ldaca.app.ready.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ldaca.app.ready.data.domain.Repo

class ViewModelFactory(private val repo: Repo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}