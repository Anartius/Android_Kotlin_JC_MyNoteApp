package com.example.jcmynoteapp.utils

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date): Long = date.time

    @TypeConverter
    fun dateStampFromTime(timeStamp: Long): Date = Date(timeStamp)
}