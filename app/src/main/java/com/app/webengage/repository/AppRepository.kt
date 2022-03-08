package com.app.webengage.repository

import com.app.webengage.baseresult.safeApiCall
import com.app.webengage.localdatabaseservice.AppLocalRoomDatabaseDao
import com.app.webengage.localdatabaseservice.entities.PersonEntity
import com.app.webengage.localdatabaseservice.entities.StudentEntity
import com.app.webengage.remoteservice.ApiHelper
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