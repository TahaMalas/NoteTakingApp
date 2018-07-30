package com.tahamalas.notetakingapp.datalayer.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.tahamalas.notetakingapp.datalayer.Note

@Database(entities = [(Note::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

}