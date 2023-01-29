package com.bine.pokejuizo.ability

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

class AbilitiesAdapter : ListAdapter<Ability, AbilitiesAdapter.AbilityViewHolder>(AbilityComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : AbilityViewHolder {

        println("Called onCreateViewHolder")
        return AbilityViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : AbilityViewHolder, position : Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class AbilityViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun bind(ability: Ability?) {

            itemView.findViewById<TextView>(R.id.item_title).text = ability!!.name

            view.setOnClickListener {

                val intent = Intent(view.context, ShowAbility::class.java)

                intent.putExtra("Ability", ability.json)

                startActivity(view.context, intent, intent.extras)
            }
        }

        companion object {
            fun create(parent: ViewGroup) : AbilityViewHolder {

                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_book, parent, false)
                return AbilityViewHolder(view)
            }
        }
    }

    class AbilityComparator : DiffUtil.ItemCallback<Ability>() {
        override fun areItemsTheSame(oldItem: Ability, newItem: Ability): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Ability, newItem: Ability): Boolean {
            return oldItem.id == newItem.id
        }
    }
}