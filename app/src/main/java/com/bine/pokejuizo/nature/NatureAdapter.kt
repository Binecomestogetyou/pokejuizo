package com.bine.pokejuizo.nature

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bine.pokejuizo.R

class NatureAdapter : ListAdapter<Nature, NatureAdapter.NatureViewHolder>(NatureComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : NatureViewHolder {

        return NatureViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : NatureViewHolder, position : Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class NatureViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun bind(nature: Nature?) {

            itemView.findViewById<TextView>(R.id.item_title).text = nature!!.name

            view.setOnClickListener {

                val intent = Intent(view.context, ShowNature::class.java)

                intent.putExtra("Nature", nature.json)

                startActivity(view.context, intent, intent.extras)
            }
        }

        companion object {
            fun create(parent: ViewGroup) : NatureViewHolder {

                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_book, parent, false)
                return NatureViewHolder(view)
            }
        }
    }

    class NatureComparator : DiffUtil.ItemCallback<Nature>() {
        override fun areItemsTheSame(oldItem: Nature, newItem: Nature): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Nature, newItem: Nature): Boolean {
            return oldItem.id == newItem.id
        }
    }
}