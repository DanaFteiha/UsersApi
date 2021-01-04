package com.example.usersapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Provides
import javax.inject.Inject
import javax.inject.Provider

class MainViewModelFactory@Inject constructor(private val mainViewModelProvider: Provider<MainViewModel>): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return mainViewModelProvider.get() as T
    }
}