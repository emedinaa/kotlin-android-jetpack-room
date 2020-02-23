package com.emedinaa.room.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AvatarDbDataSource: AvatarDataSource {

    override fun getAll(): LiveData<AvatarDb> {
        return MutableLiveData<AvatarDb>()
    }

    override fun add(avatar: AvatarDb) {

    }

    override fun remove(avatar: AvatarDb) {

    }

    override fun update(avatar: AvatarDb) {

    }
}