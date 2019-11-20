package com.android.jetpack.utils

import android.content.Context
import com.android.jetpack.data.AppDatabase
import com.android.jetpack.data.GardenPlantingRepository
import com.android.jetpack.data.PlantRepository
import com.android.jetpack.vm.GardenPlantingListViewModelFactory
import com.android.jetpack.vm.PlantDetailViewModelFactory
import com.android.jetpack.vm.PlantListViewModelFactory

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/

object InjectorUtils {

    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(AppDatabase.getInstance(context.applicationContext).plantDao())
    }

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context.applicationContext).gardenPlantingDao())
    }

    fun provideGardenPlantingListViewModelFactory(context: Context): GardenPlantingListViewModelFactory {
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
    }

    fun providePlantListViewModelFactory(context: Context): PlantListViewModelFactory {
        val repository = getPlantRepository(context)
        return PlantListViewModelFactory(repository)
    }


    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(
            getPlantRepository(context),
            getGardenPlantingRepository(context),
            plantId
        )
    }


}