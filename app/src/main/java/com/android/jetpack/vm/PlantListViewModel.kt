package com.android.jetpack.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.android.jetpack.data.Plant
import com.android.jetpack.data.PlantRepository

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/20
 * Instructions:
 **/
class PlantListViewModel internal constructor(plantRepository: PlantRepository) : ViewModel() {

    private val growZoneNumber = MutableLiveData<Int>(NO_GROW_ZONE)


    val plantList: LiveData<List<Plant>> = growZoneNumber.switchMap {
        if (it == NO_GROW_ZONE) {
            plantRepository.getPlantList()
        } else {
            plantRepository.getPlantsWithGrowZoneNumber(it)
        }
    }

    fun setGrowZoneNumber(num: Int) {
        growZoneNumber.value = num
    }

    fun clearGrowZoneNumber() {
        growZoneNumber.value = NO_GROW_ZONE
    }

    fun isFiltered() = growZoneNumber.value != NO_GROW_ZONE


    companion object {
        private const val NO_GROW_ZONE = -1
    }

}