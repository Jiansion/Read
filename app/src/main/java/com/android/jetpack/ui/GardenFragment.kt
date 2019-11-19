package com.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.viewpager2.widget.ViewPager2
import com.android.jetpack.R
import com.android.jetpack.adapter.GardenPlantingAdapter
import com.android.jetpack.adapter.PLANT_LIST_PAGE_INDEX
import com.android.jetpack.databinding.FragmentGardenBinding
import com.android.jetpack.utils.InjectorUtils
import com.android.jetpack.vm.GardenPlantingListViewModel

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/18
 * Instructions:
 **/
class GardenFragment : Fragment() {

    private val viewModel: GardenPlantingListViewModel by viewModels {
        InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGardenBinding.inflate(inflater, container, false)
        val adapter = GardenPlantingAdapter()
        binding.rvGarden.adapter = adapter

        binding.btnAddPlant.setOnClickListener {
            navigationToPlantListPage()
        }
        subscribeUI(adapter, binding)
        return binding.root
    }

    private fun subscribeUI(adapter: GardenPlantingAdapter, binding: FragmentGardenBinding) {
        viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner) { result ->
            binding.hasPlantings = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }


    private fun navigationToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            PLANT_LIST_PAGE_INDEX
    }
}