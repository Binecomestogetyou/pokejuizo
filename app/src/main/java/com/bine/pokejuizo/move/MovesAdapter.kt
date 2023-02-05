package com.bine.pokejuizo.move

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
import com.bine.pokejuizo.move.Move

class MovesAdapter : ListAdapter<Move, MovesAdapter.MoveViewHolder>(MoveComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MoveViewHolder {

        return MoveViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : MoveViewHolder, position : Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class MoveViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        fun bind(move: Move?) {

            itemView.findViewById<TextView>(R.id.item_title).text = move!!.name

            view.setOnClickListener {

                val intent = Intent(view.context, ShowMove::class.java)

                intent.putExtra("Move", move.json)

                startActivity(view.context, intent, intent.extras)
            }
        }

        companion object {
            fun create(parent: ViewGroup) : MoveViewHolder {

                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_book, parent, false)
                return MoveViewHolder(view)
            }
        }
    }

    class MoveComparator : DiffUtil.ItemCallback<Move>() {
        override fun areItemsTheSame(oldItem: Move, newItem: Move): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Move, newItem: Move): Boolean {
            return oldItem.id == newItem.id
        }
    }
}