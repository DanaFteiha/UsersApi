package com.example.usersapi

import dagger.Component
import javax.inject.Singleton

//The Injector
@Singleton
@Component (modules = [MainModule::class , ApiModule::class])
interface MainComponent {
        // This tells Dagger that MainActivity requests injection so the graph needs to
        // satisfy all the dependencies of the fields that MainActivity is requesting.
        fun inject (activity: MainActivity)
}