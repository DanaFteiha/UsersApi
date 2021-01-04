package com.example.usersapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    //MutableLiveData String that stores the most recent response
    val response : MutableLiveData<List<Person>> = MutableLiveData()


    fun getUsers(){
        viewModelScope.launch {
            try {
                val listResult = repository.getUsers()
                val persons = listResult.results.map {
                    Person(gender = it.gender,email = it.email,name = it.name.first)
                }
                response.value =  persons
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}

