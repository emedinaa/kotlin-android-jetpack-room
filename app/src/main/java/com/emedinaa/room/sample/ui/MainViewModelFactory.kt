package com.emedinaa.room.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.room.sample.model.ResourceRepository

/**
 * @author Eduardo Medina
 */
class MainViewModelFactory(
    private val repository: ResourceRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}