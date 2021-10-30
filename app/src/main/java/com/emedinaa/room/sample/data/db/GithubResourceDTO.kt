package com.emedinaa.room.sample.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Eduardo Medina
 */
@Entity(tableName = "Resource")
data class GithubResourceDTO(
    @ColumnInfo(name = "name") val name: String?, @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "icon") val icon: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
