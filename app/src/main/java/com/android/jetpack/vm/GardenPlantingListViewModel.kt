package com.android.jetpack.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.jetpack.data.GardenPlantingRepository
import com.android.jetpack.data.PlantAndGardenPlantings

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/18
 * Instructions:
 **/
class GardenPlantingListViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()

}