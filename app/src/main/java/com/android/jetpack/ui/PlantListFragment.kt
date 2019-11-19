package com.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.jetpack.databinding.FragmentPlantListBinding

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/18
 * Instructions:
 **/
class PlantListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantListBinding.inflate(inflater, container, false)

        return binding.root
    }
}