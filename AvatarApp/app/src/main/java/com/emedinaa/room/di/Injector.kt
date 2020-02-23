package com.emedinaa.room.di

import android.content.Context
import com.emedinaa.room.data.AvatarDbRepository
import com.emedinaa.room.data.AvatarRepository

object Injector {

    private lateinit var avatarRepository:AvatarRepository

    fun setup(context:Context){
        avatarRepository = AvatarDbRepository(context)
    }

    fun provideRepository()= avatarRepository
}