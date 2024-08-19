package com.example.sagar.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sagar.R

class TeamAdapter(private val mdata: List<TeamItem>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val teamItem = mdata[position]
        holder.tv_name.text = teamItem.name
        holder.tv_desc.text = teamItem.description
        holder.img.setImageResource(teamItem.imageResId)
    }

    override fun getItemCount(): Int {
        return mdata.size
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_name: TextView = itemView.findViewById(R.id.team_item_name)
        val tv_desc: TextView = itemView.findViewById(R.id.team_item_desc)
        val img: ImageView = itemView.findViewById(R.id.team_item_img)
    }
}
