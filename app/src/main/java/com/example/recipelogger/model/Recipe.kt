package com.example.recipelogger.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(

    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "ingredient")
    var ingredient: String,

    @ColumnInfo(name = "image")
    var image: ByteArray,
    @ColumnInfo(name = "instruction")
    var instruction: String,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
