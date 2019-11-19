package com.android.jetpack.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import java.util.Calendar.DAY_OF_YEAR

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey @ColumnInfo(name = "id")
    val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7, // how often the plant should be watered, in days
    val imageUrl: String = ""
) {

    fun shouldBeWatered(since: Calendar, lastWateringDate: Calendar): Boolean {
        return since > lastWateringDate.apply { add(DAY_OF_YEAR, wateringInterval) }
    }

    override fun toString(): String {
        return name
    }

}