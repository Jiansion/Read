package com.android.jetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.jetpack.data.GardenPlantingRepository
import com.android.jetpack.data.PlantRepository

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/20
 * Instructions:
 **/
class PlantDetailViewModelFactory(
    private val plantRepository: PlantRepository,
    private val gradenPlantingRepository: GardenPlantingRepository,
    private val plantId: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantDetailViewModel(plantRepository, gradenPlantingRepository, plantId) as T
    }

}