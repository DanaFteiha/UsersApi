package com.example.usersapi

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun bindMainViewModel(factory: MainViewModelFactory): ViewModelProvider.Factory
}