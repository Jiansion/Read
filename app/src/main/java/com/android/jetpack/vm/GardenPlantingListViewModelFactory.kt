package com.android.jetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.jetpack.data.GardenPlantingRepository

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
class GardenPlantingListViewModelFactory(private val repository: GardenPlantingRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }
}