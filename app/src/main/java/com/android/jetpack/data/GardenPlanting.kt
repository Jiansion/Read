package com.android.jetpack.data

import androidx.room.*
import java.util.*

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/

@Entity(
    tableName = "garden_plantings",
    foreignKeys = [ForeignKey(
        entity = Plant::class,
        parentColumns = ["id"],
        childColumns = ["plant_id"]
    )],
    indices = [Index("plant_id")]
)
data class GardenPlanting(
    @ColumnInfo(name = "plant_id")
    val plantId: String,

    @ColumnInfo(name = "plant_data")
    val plantDate: Calendar = Calendar.getInstance(),

    @ColumnInfo(name = "last_watering_date")
    val lastWateringDate: Calendar = Calendar.getInstance()
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var gardenPlantingId: Long = 0L

}