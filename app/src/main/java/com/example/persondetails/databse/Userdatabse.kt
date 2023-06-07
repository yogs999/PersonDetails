package com.example.persondetails.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persondetails.dao.UserDao
import com.example.persondetails.model.UserDataItem


@Database(entities = arrayOf(UserDataItem::class),version=1)
abstract class Userdatabse :RoomDatabase() {

    abstract fun userDao():UserDao

    companion object {
        @Volatile
        var INSTANCES: Userdatabse? = null

        fun getInstance(context: Context): Userdatabse {
            val tempInstance = INSTANCES
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val database = Room.databaseBuilder(context, Userdatabse::class.java, "demodb").allowMainThreadQueries()
                    .build()
                INSTANCES = database
                return database
            }
        }
    }
}