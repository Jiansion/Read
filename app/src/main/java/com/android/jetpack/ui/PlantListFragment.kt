package com.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.android.jetpack.adapter.PlantAdapter
import com.android.jetpack.databinding.FragmentPlantListBinding
import com.android.jetpack.utils.InjectorUtils
import com.android.jetpack.vm.PlantListViewModel

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/18
 * Instructions:
 **/
class PlantListFragment : Fragment() {

    private val viewModel: PlantListViewModel by viewModels {
        InjectorUtils.providePlantListViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantListBinding.inflate(inflater, container, false)

        context ?: return binding.root

        val adapter = PlantAdapter()
        binding.rvPlantList.adapter = adapter
        subscribeUI(adapter)

        return binding.root
    }


    private fun subscribeUI(adapter: PlantAdapter) {
        viewModel.plantList.observe(viewLifecycleOwner) { plantList ->
            adapter.submitList(plantList)
        }
    }


}