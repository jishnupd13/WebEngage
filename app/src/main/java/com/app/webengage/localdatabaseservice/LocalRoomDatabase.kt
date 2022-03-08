package com.app.webengage.localdatabaseservice

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.webengage.localdatabaseservice.entities.PersonEntity
import com.app.webengage.localdatabaseservice.entities.StudentEntity

/** Created by Jishnu P Dileep on 27-05-2021 */

@Database(entities = [StudentEntity::class,PersonEntity::class], version = 1, exportSchema = false)
abstract class LocalRoomDatabase : RoomDatabase() {
    /**
     * Connects the database to the DAO.
     */
    abstract fun appLocalRoomDatabaseDao(): AppLocalRoomDatabaseDao
}