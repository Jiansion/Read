package com.android.jetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.jetpack.data.GardenPlantingRepository
import com.android.jetpack.data.PlantRepository
import kotlinx.coroutines.launch

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/20
 * Instructions:
 **/
class PlantDetailViewModel(
    plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    private val plantId: String
) : ViewModel() {

    val isPlanted = gardenPlantingRepository.isPlanted(plantId)

    val plant = plantRepository.getPlantById(plantId)

    fun addPlantToGarden() {
        viewModelScope.launch {
            gardenPlantingRepository.createGardenPlanting(plantId)
        }
    }
}