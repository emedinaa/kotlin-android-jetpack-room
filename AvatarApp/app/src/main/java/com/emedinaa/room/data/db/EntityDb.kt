package com.emedinaa.room.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emedinaa.room.model.Avatar

/**
 * https://developer.android.com/training/data-storage/room/defining-data.html
 */

@Entity(tableName = "avatar")
data class AvatarDb(@PrimaryKey val id:Int,
                      @ColumnInfo(name = "name") val name:String?,
                      @ColumnInfo(name = "image") val photo:String?){

    fun toAvatar():Avatar{
        return Avatar(id,name,"",photo)
    }
}