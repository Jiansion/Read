package com.android.jetpack.vm

import com.android.jetpack.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings) {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.gardenPlantings[0]

    val waterDateString: String = dateFormat.format(gardenPlanting.lastWateringDate.time)

    val waterinInterval get() = plant.wateringInterval

    val imageUrl get() = plant.imageUrl

    val plantName get() = plant.name

    val plantDateString: String = dateFormat.format(gardenPlanting.plantDate.time)

    val plantId get() = plant.plantId


    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.US)
    }
}