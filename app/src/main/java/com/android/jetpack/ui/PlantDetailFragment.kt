package com.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.jetpack.R
import com.android.jetpack.databinding.FragmentPlantDetailBinding

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/18
 * Instructions:
 **/
class PlantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater, R.layout.fragment_plant_detail, container, false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

}