package com.android.jetpack.data

import androidx.room.TypeConverter
import java.util.*

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions: Type converters to allow Room to reference complex data types.
 *  类型转换器，是的 Room 可以存储复杂的数据类型
 **/
class Converters {
    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }
}