package com.android.jetpack.data

import androidx.lifecycle.LiveData

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
class GardenPlantingRepository private constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {
    suspend fun createGardenPlanting(plantId: String) {
        gardenPlantingDao.insertGardenPlanting(GardenPlanting(plantId))
    }

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting)
    }

    fun isPlanted(plantId: String): LiveData<Boolean> {
        return gardenPlantingDao.isPlanted(plantId)
    }

    fun getPlantedGardens(): LiveData<List<PlantAndGardenPlantings>> {
        return gardenPlantingDao.getPlantedGardens()
    }

    companion object {
        private var instance: GardenPlantingRepository? = null

        fun getInstance(gardenPlantingDao: GardenPlantingDao): GardenPlantingRepository {
            return instance ?: synchronized(this) {
                instance ?: GardenPlantingRepository(gardenPlantingDao).also { instance = it }
            }
        }
    }

}