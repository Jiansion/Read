package com.android.jetpack.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ShareCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.android.jetpack.R
import com.android.jetpack.data.Plant
import com.android.jetpack.databinding.FragmentPlantDetailBinding
import com.android.jetpack.utils.InjectorUtils
import com.android.jetpack.vm.PlantDetailViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * @author: YeJian
 * @email: amazeconch@gmail.com
 * Create on: 2019/11/18
 * Instructions:
 **/
class PlantDetailFragment : Fragment() {

    private val args: PlantDetailFragmentArgs by navArgs()

    private val plantDetailViewModel: PlantDetailViewModel by viewModels {
        InjectorUtils.providePlantDetailViewModelFactory(requireActivity(), args.plantId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantDetailBinding.inflate(inflater, container, false)
        binding.viewModel = plantDetailViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.callback = object : Callback {
            override fun add(plant: Plant) {
                plant.let {
                    hideAppBarFab(binding.floatActionBtn)
                    plantDetailViewModel.addPlantToGarden()
                    Snackbar.make(
                        binding.root,
                        R.string.added_plant_to_garden,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
        var isToolbarShown = false
        binding.plantDetailScroller.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                val shouldShowToolbar = scrollY > binding.toolbar.height
                if (isToolbarShown != shouldShowToolbar) {
                    isToolbarShown = shouldShowToolbar
                    binding.appBar.isActivated = shouldShowToolbar
                    binding.toolbarLayout.isTitleEnabled = shouldShowToolbar
                }
            }
        )
        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_share -> {
                    createShareIntent()
                    true
                }
                else -> false
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }


    private fun createShareIntent() {
        var shareText = plantDetailViewModel.plant.value.let {
            if (it == null) {
                "title is null"
            } else {
                getString(R.string.share_text_plant, it.name)
            }
        }

        var shareIntent = ShareCompat.IntentBuilder.from(activity)
            .setText(shareText)
            .setType("text/plain")
            .createChooserIntent()
            .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(shareIntent)
    }


    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }


    interface Callback {
        fun add(plant: Plant)
    }

}