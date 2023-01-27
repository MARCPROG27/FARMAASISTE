package com.example.appmarte.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appmarte.Model.Remote.MarsRealState

@Database(entities = [MarsRealState::class], version = 1)
abstract class MarsDatabase : RoomDatabase() {
abstract fun getMarsDao(): MarsDao


companion object {
    @Volatile
    private var INSTANCE: MarsDatabase? = null

    fun getDataBase(context: Context): MarsDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                MarsDatabase::class.java,
                "mars_db_farma"
            )
                .build()
            INSTANCE = instance
            return instance
        }
    }
}








}