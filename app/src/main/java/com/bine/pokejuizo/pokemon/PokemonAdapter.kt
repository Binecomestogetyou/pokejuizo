package com.bine.pokejuizo.pokemon

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
import com.bine.pokejuizo.pokemon.Pokemon
import com.bine.pokejuizo.pokemon.ShowPokemon

class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(PokemonComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : PokemonViewHolder {

        return PokemonViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : PokemonViewHolder, position : Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class PokemonViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun bind(pokemon: Pokemon?) {

            itemView.findViewById<TextView>(R.id.item_title).text = pokemon!!.name

            view.setOnClickListener {

                val intent = Intent(view.context, ShowPokemon::class.java)

                intent.putExtra("Pokemon", pokemon.json)

                ContextCompat.startActivity(view.context, intent, intent.extras)
            }
        }

        companion object {
            fun create(parent: ViewGroup) : PokemonViewHolder {

                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_book, parent, false)
                return PokemonViewHolder(view)
            }
        }
    }

    class PokemonComparator : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }
    }
}