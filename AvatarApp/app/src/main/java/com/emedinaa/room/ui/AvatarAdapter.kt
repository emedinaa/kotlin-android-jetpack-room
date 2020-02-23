package com.emedinaa.room.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.room.R
import com.emedinaa.room.model.Avatar

class AvatarAdapter(private var avatarList:List<Avatar>): RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_avatar,parent,false))
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}

    fun update(avatarList:List<Avatar>){
        this.avatarList = avatarList
    }

    inner class ViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        fun bind(avatar:Avatar){

        }
    }
}