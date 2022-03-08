package com.app.webengage.localdatabaseservice.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data
class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val fName: String,
    val lName: String,
    val email: String,
    val phone:String,
    val webEngageId: String,
    val password:String
)