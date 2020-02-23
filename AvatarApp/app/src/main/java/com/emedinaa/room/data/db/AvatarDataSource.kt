package com.emedinaa.room.data.db

import androidx.lifecycle.LiveData
import com.emedinaa.room.data.db.AvatarDb

interface AvatarDataSource {

    fun getAll():LiveData<AvatarDb>
    fun add(avatar: AvatarDb)
    fun update(avatar: AvatarDb)
    fun remove(avatar: AvatarDb)
}