package com.emedinaa.room.sample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * @author Eduardo Medina
 */
@Dao
interface GithubResourceDao {

    //@Query("SELECT * from Resource order by timestamp desc")
    @Query("SELECT * from Resource")
    fun getAll(): Flow<List<GithubResourceDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(resourceDTO: GithubResourceDTO)
}