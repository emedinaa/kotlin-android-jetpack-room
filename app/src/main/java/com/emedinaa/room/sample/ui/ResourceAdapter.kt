package com.emedinaa.room.sample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.room.sample.R
import com.emedinaa.room.sample.model.GithubResource

/**
 * @author Eduardo Medina
 */
class ResourceAdapter(
    private var resources: List<GithubResource>,
    private val itemAction: (resource: GithubResource) -> Unit
) :
    RecyclerView.Adapter<
            ResourceAdapter.ResourceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.row,
            parent, false
        )
        return ResourceViewHolder(view)
    }

    override fun getItemCount(): Int = resources.size

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        holder.bind(resources[position])
    }

    //todo refactor diffutils
    fun update(data: List<GithubResource>) {
        resources = data
        notifyDataSetChanged()
    }

    inner class ResourceViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewTitle = view.findViewById<TextView>(R.id.textViewTitle)
        private val textViewUrl = view.findViewById<TextView>(R.id.textViewUrl)
        fun bind(resource: GithubResource) {
            textViewTitle.text = resource.name
            textViewUrl.text = resource.url

            view.setOnClickListener {
                itemAction(resource)
            }
        }
    }
}