package com.emedinaa.room.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.room.R
import com.emedinaa.room.model.Avatar
import kotlinx.android.synthetic.main.row_avatar.view.*

class AvatarAdapter(private var avatarList:List<Avatar>): RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_avatar,parent,false))
    }

    override fun getItemCount(): Int = avatarList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(avatarList[position])
    }

    fun update(avatarList:List<Avatar>){
        this.avatarList = avatarList
    }

    inner class ViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        private val textView = view.textViewTitle
        private val textViewSubtitle = view.textViewSubtitle
        fun bind(avatar:Avatar){
            textView.text = avatar.name
            textViewSubtitle.text = avatar.desc
        }
    }
}