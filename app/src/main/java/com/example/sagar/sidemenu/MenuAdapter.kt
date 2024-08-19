package com.example.sagar.sidemenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sagar.R

class MenuAdapter(private val mData: List<MenuItem>, private val listener: Callback) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = mData[position]
        holder.icon.setImageResource(menuItem.icon)
        holder.isSelected.visibility = if (menuItem.isSelected) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.item_menu_icon)
        val isSelected: ImageView = itemView.findViewById(R.id.item_menu_selected)

        init {
            itemView.setOnClickListener { listener.onSideMenuItemClick(adapterPosition) }
        }
    }
}
