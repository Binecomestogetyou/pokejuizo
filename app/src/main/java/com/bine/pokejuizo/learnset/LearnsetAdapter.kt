package com.bine.pokejuizo.learnset

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

class LearnsetAdapter : ListAdapter<Learnset, LearnsetAdapter.LearnsetViewHolder>(LearnsetComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : LearnsetViewHolder {

        return LearnsetViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : LearnsetViewHolder, position : Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class LearnsetViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun bind(learnset: Learnset?) {

            itemView.findViewById<TextView>(R.id.item_title).text = learnset!!.name

            view.setOnClickListener {

                val intent = Intent(view.context, ShowLearnset::class.java)

                intent.putExtra("Learnset", learnset.json)

                ContextCompat.startActivity(view.context, intent, intent.extras)
            }
        }

        companion object {
            fun create(parent: ViewGroup) : LearnsetViewHolder {

                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_book, parent, false)
                return LearnsetViewHolder(view)
            }
        }
    }

    class LearnsetComparator : DiffUtil.ItemCallback<Learnset>() {
        override fun areItemsTheSame(oldLearnset: Learnset, newLearnset: Learnset): Boolean {
            return oldLearnset === newLearnset
        }

        override fun areContentsTheSame(oldLearnset: Learnset, newLearnset: Learnset): Boolean {
            return oldLearnset.id == newLearnset.id
        }
    }
}