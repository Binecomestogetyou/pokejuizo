package com.bine.pokejuizo.item

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bine.pokejuizo.R

class ItemAdapter : ListAdapter<Item, ItemAdapter.ItemViewHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ItemViewHolder {

        return ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : ItemViewHolder, position : Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun bind(item: Item?) {

            itemView.findViewById<TextView>(R.id.item_title).text = item!!.name

            view.setOnClickListener {

                val intent = Intent(view.context, ShowItem::class.java)

                intent.putExtra("Item", item.json)

                ContextCompat.startActivity(view.context, intent, intent.extras)
            }
        }

        companion object {
            fun create(parent: ViewGroup) : ItemViewHolder {

                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_book, parent, false)
                return ItemViewHolder(view)
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }
    }
}