package com.emedinaa.room.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.emedinaa.room.sample.mesage.DataResult
import com.emedinaa.room.sample.model.GithubResource
import com.emedinaa.room.sample.model.ResourceRepository
import kotlinx.coroutines.launch

/**
 * @author Eduardo Medina
 */
class MainViewModel(private val repository: ResourceRepository) : ViewModel() {

    val resources: LiveData<List<GithubResource>> = repository.fetchResources().asLiveData()

    fun addResource(resource: GithubResource) {
        viewModelScope.launch {
            //TODO
            when(repository.addResource(resource)) {
                is DataResult.Success -> { }
                is DataResult.Failure -> { }
            }
        }
    }
}