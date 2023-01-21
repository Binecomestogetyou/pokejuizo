package com.bine.pokejuizo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TrainersAdapter : ListAdapter<Trainer, TrainersAdapter.TrainerViewHolder>(TrainerComparator()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : TrainerViewHolder {
        return TrainerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder : TrainerViewHolder, position : Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class TrainerViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val trainerName : TextView = itemView.findViewById(R.id.item_trainer_trainer_name)
        private val trainerRank : TextView = itemView.findViewById(R.id.item_trainer_trainer_rank)
        private val trainerAge : TextView = itemView.findViewById(R.id.item_trainer_trainer_age)
        private val trainerNature : TextView = itemView.findViewById(R.id.item_trainer_trainer_nature)

        fun bind(trainer: Trainer?) {
            println("Bind was called with " + trainer.toString())
            trainerName.text = trainer!!.Name
            trainerRank.text = trainer.Rank
            trainerAge.text = trainer.Age
            trainerNature.text = trainer.Nature
        }

        companion object {
            fun create(parent: ViewGroup) : TrainerViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_trainer, parent, false)
                return TrainerViewHolder(view)
            }
        }
    }

    class TrainerComparator : DiffUtil.ItemCallback<Trainer>() {
        override fun areItemsTheSame(oldItem: Trainer, newItem: Trainer): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Trainer, newItem: Trainer): Boolean {
            return oldItem.id == newItem.id
        }
    }
}