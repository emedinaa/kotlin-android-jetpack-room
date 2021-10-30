package com.emedinaa.room.sample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author Eduardo Medina
 */
@Database(entities = [GithubResourceDTO::class], version = 1, exportSchema = false)

abstract class GithubResourceDatabase : RoomDatabase() {

    abstract fun resourceDao(): GithubResourceDao

    companion object {
        private const val DB_NAME = "GithubResources.db"
        private var INSTANCE: GithubResourceDatabase? = null

        fun getInstance(context: Context): GithubResourceDatabase {
            if (INSTANCE == null) {
                synchronized(GithubResourceDatabase::class.java) {
                    INSTANCE =
                        Room.databaseBuilder(context, GithubResourceDatabase::class.java, DB_NAME)
                            .createFromAsset("githubresources.db")
                            .build()

                }
            }
            return INSTANCE ?: throw Exception("DBNote !=null")
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}