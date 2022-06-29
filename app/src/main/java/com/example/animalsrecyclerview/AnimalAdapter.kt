package com.example.animalsrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsrecyclerview.databinding.ItemAnimalBinding
import java.util.ArrayList

class AnimalAdapter(private val data: ArrayList<Animal>, private val onItemLongClick: OnItemLongClick) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    private var count: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(data.get(position))
        holder.itemView.setOnLongClickListener {
            onItemLongClick.onItemLongClick(position)
            true
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class AnimalViewHolder(private val binding: ItemAnimalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            binding.count.text = count.toString()
            binding.name.text = animal.name
            binding.image.loadData(animal.image.toString())
            count++
        }
    }


}