package com.android.jetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.jetpack.data.PlantRepository

class PlantListViewModelFactory(private val repository: PlantRepository) :
    ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantListViewModel(repository) as T
    }

}
