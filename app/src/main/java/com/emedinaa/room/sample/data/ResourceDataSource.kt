package com.emedinaa.room.sample.data

import com.emedinaa.room.sample.data.db.GithubResourceDTO
import com.emedinaa.room.sample.data.db.GithubResourceDao
import com.emedinaa.room.sample.mesage.DataResult
import com.emedinaa.room.sample.model.GithubResource
import com.emedinaa.room.sample.model.ResourceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * @author Eduardo Medina
 */
class ResourceDataSource(private val dao: GithubResourceDao) : ResourceRepository {

    override fun fetchResources(): Flow<List<GithubResource>> = dao.getAll().map { resources ->
        resources.map {
            GithubResource(it.id, it.name ?: "", it.url ?: "", it.icon ?: "")
        }
    }

    override suspend fun addResource(resource: GithubResource): DataResult<String> =
        withContext(Dispatchers.IO) {
            try {
                dao.insert(GithubResourceDTO(resource.name, resource.url, resource.icon))
                DataResult.Success("")
            } catch (exception: Exception) {
                DataResult.Failure(exception)
            }
        }

}