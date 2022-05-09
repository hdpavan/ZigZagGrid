package com.tutorialsbuzz.androidflowsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tutorialsbuzz.androidflowsample.databinding.EachItemBinding
import com.tutorialsbuzz.androidflowsample.model.Tiles

class GridAdapter : RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    val diffUtil = object : DiffUtil.ItemCallback<Tiles>() {
        override fun areItemsTheSame(oldItem: Tiles, newItem: Tiles): Boolean {
            return oldItem.label == newItem.label
        }

        override fun areContentsTheSame(oldItem: Tiles, newItem: Tiles): Boolean {
            return oldItem == newItem
        }

    }

    var differ = AsyncListDiffer(this, diffUtil)


    class ViewHolder(val binding: EachItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.tilesLabel.setText(differ.currentList.get(position).label)


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun updateItems(items: List<Tiles>) {
        differ.submitList(items)
    }


}