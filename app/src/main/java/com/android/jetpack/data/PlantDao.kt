package com.android.jetpack.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlantDao {


    @Query("select * from plants order by name")
    fun getPlantsList(): LiveData<List<Plant>>

    @Query("select * from plants where growZoneNumber =:growZoneNumber order by name")
    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): LiveData<List<Plant>>


    @Query("select * from plants where id=:plantId")
    fun getPlantById(plantId: String): LiveData<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Plant>)

}
