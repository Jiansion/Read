package com.android.jetpack.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
@Dao
interface GardenPlantingDao {

    @Query("select * from garden_plantings")
    fun getGardenPlantings(): LiveData<List<GardenPlanting>>

    @Query("select exists(select 1 from garden_plantings where plant_id = :plantId limit 1)")
    fun isPlanted(plantId: String): LiveData<Boolean>


    @Transaction
    @Query("select * from plants where id in (select distinct(plant_id) from garden_plantings)")
    fun getPlantedGardens(): LiveData<List<PlantAndGardenPlantings>>

    @Insert
    suspend fun insertGardenPlanting(gardenPlantings: GardenPlanting): Long

    @Delete
    suspend fun deleteGardenPlanting(gardenPlantings: GardenPlanting)

}