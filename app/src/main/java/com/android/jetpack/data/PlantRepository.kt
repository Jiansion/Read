package com.android.jetpack.data

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/20
 * Instructions:
 **/
class PlantRepository private constructor(private val plantDao: PlantDao) {

    fun getPlantList() = plantDao.getPlantsList()

    fun getPlantById(plantId: String) = plantDao.getPlantById(plantId)


    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)


    companion object {

        @Volatile
        private var instance: PlantRepository? = null

        fun getInstance(plantDao: PlantDao): PlantRepository {
            return instance ?: synchronized(this) {
                instance ?: PlantRepository(plantDao).also { instance = it }
            }
        }
    }


}