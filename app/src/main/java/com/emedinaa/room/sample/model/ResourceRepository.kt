package com.emedinaa.room.sample.model

import com.emedinaa.room.sample.mesage.DataResult
import kotlinx.coroutines.flow.Flow

/**
 * @author Eduardo Medina
 */
interface ResourceRepository {

    fun fetchResources(): Flow<List<GithubResource>>

    suspend fun addResource(resource: GithubResource): DataResult<String>
}