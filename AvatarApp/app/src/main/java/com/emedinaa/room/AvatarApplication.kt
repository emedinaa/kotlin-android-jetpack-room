package com.emedinaa.room

import android.app.Application
import com.emedinaa.room.di.Injector

class AvatarApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.setup(this)
    }
}