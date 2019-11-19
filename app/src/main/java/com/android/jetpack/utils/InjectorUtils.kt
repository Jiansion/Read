package com.android.jetpack.utils

import android.content.Context
import com.android.jetpack.data.AppDatabase
import com.android.jetpack.data.GardenPlantingRepository
import com.android.jetpack.vm.GardenPlantingListViewModelFactory

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/

object InjectorUtils {


    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context.applicationContext).gardenPlantingDao())
    }

    fun provideGardenPlantingListViewModelFactory(context: Context): GardenPlantingListViewModelFactory {
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
    }
}