package com.android.jetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.jetpack.adapter.PlantAdapter.PlantViewHolder
import com.android.jetpack.data.Plant
import com.android.jetpack.databinding.ItemListPlantBinding
import com.android.jetpack.ui.HomeViewPagerFragmentDirections

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/19
 * Instructions:
 **/
class PlantAdapter : ListAdapter<Plant, PlantViewHolder>(PlantDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return PlantViewHolder(
            ItemListPlantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class PlantViewHolder(private val binding: ItemListPlantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { v ->
                binding.plant?.let { plant ->
                    navigationToPlant(plant, v)
                }
            }
        }

        private fun navigationToPlant(plant: Plant, view: View) {
            val direction =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plant.plantId)
            view.findNavController().navigate(direction)
        }

        fun bind(item: Plant) {
            binding.plant = item
            binding.executePendingBindings()
        }


    }


}

private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {

    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }


    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }


}