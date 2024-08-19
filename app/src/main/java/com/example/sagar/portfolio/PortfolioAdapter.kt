package com.example.sagar.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sagar.R

class PortfolioAdapter(
    private val portfolioList: List<PortfolioItem>,
    private val callback: PortfolioCallback
) : RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_portfolio, parent, false)
        return PortfolioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val currentItem = portfolioList[position]
        holder.imageView.setImageResource(currentItem.imageResId)
        holder.itemView.setOnClickListener {
            callback.onPortfolioItemClick(position)
        }
    }

    override fun getItemCount() = portfolioList.size

    class PortfolioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_portfolio_img)
    }
}
