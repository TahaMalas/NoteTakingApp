package com.tahamalas.notetakingapp.datalayer

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note")
data class Note(@PrimaryKey var date: Long, val name: String, val description: String)