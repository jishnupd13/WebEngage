package com.app.mymainapp.repository

import com.app.mymainapp.baseresult.safeApiCall
import com.app.mymainapp.localdatabaseservice.AppLocalRoomDatabaseDao
import com.app.mymainapp.localdatabaseservice.entities.PersonEntity
import com.app.mymainapp.localdatabaseservice.entities.StudentEntity
import com.app.mymainapp.remoteservice.ApiHelper
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val apiHelper: ApiHelper,
    private val appLocalRoomDatabaseDao: AppLocalRoomDatabaseDao
) {

    suspend fun getPosts() = safeApiCall { apiHelper.getPosts() }
    //  suspend fun getNestedPosts()= safeApiCall { apiHelper.getNestedPosts() }

    //for room DataBase
    suspend fun insertStudentData(student: StudentEntity) = appLocalRoomDatabaseDao.insert(student)
    suspend fun fetchStudents() = appLocalRoomDatabaseDao.fetch()

    suspend fun insertPerson(personEntity: PersonEntity) =
        appLocalRoomDatabaseDao.insertPerson(personEntity)

    suspend fun fetchPersons() = appLocalRoomDatabaseDao.fetchPerson()
    suspend fun checkAuth(email: String, password: String) =
        appLocalRoomDatabaseDao.checkAuth(email, password)

    suspend fun fetchPersonsByWebEngageId(id: String) =
        appLocalRoomDatabaseDao.fetchPersonByWevEngageId(id)

}