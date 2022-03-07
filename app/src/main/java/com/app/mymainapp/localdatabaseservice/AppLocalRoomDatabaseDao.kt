package com.app.mymainapp.localdatabaseservice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.mymainapp.localdatabaseservice.entities.PersonEntity
import com.app.mymainapp.localdatabaseservice.entities.StudentEntity

/** Created by Jishnu P Dileep on 27-05-2021 */

@Dao
interface AppLocalRoomDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: StudentEntity): Long

    @Query("select * From student ORDER BY studentId ASC")
    suspend fun fetch(): List<StudentEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: PersonEntity): Long

    @Query("select * From person")
    suspend fun fetchPerson(): List<PersonEntity>

    @Query("select * From person where email = :email and password = :password")
    suspend fun checkAuth(email: String, password: String): List<PersonEntity>

    @Query("select * From person where webEngageId=:id ")
    suspend fun fetchPersonByWevEngageId(id: String): List<PersonEntity>

}