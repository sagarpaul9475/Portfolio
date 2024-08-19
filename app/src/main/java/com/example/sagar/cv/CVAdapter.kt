package com.example.sagar.cv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sagar.R

class CVAdapter(private val mdata: List<CVItem>) : RecyclerView.Adapter<CVAdapter.CVViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cv, parent, false)
        return CVViewHolder(view)
    }

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.tvTitle.text = mdata[position].title
        holder.tvDescription.text = mdata[position].description
    }

    override fun getItemCount(): Int {
        return mdata.size
    }

    inner class CVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.item_cv_title)
        val tvDescription: TextView = itemView.findViewById(R.id.item_cv_desc)
    }
}
