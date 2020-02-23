package com.emedinaa.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.emedinaa.room.model.Avatar
import com.emedinaa.room.ui.AvatarAdapter
import kotlinx.android.synthetic.main.activity_main.*

/*
https://material.io/develop/android/components/floating-action-button/
 */
class MainActivity : AppCompatActivity() {

    private val avatarList:MutableList<Avatar> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        fab.setOnClickListener {

        }

        retrieveAvatars()
    }

    private fun retrieveAvatars(){
        avatarList.add(Avatar(1,"Item title 1","Item demo 1",""))
        avatarList.add(Avatar(2,"Item title 2","Item demo 2",""))
        avatarList.add(Avatar(3,"Item title 3","Item demo 3",""))
        avatarList.add(Avatar(3,"Item title 4","Item demo 4",""))
        avatarList.add(Avatar(3,"Item title 5","Item demo 5",""))
        avatarList.add(Avatar(3,"Item title 6","Item demo 6",""))

        recyclerView.adapter = AvatarAdapter(avatarList)
    }
}
