package com.example.kotlin3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin3.R
import com.example.kotlin3.base.BaseFragment
import com.example.kotlin3.databinding.FragmentSelectedBinding
import com.example.kotlin3.ui.adapter.GalleryAdapter

class SelectedFragment : BaseFragment<FragmentSelectedBinding>(R.layout.fragment_selected) {

    override val binding by viewBinding(FragmentSelectedBinding::bind)
    private val viewModel: SharedViewModel by activityViewModels()
    private val adapter = GalleryAdapter()

    override fun initViews() {
        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerview.layoutManager = GridLayoutManager(context, 3)
        binding.recyclerview.adapter = adapter
    }

    override fun initObservers() {
        super.initObservers()
     viewModel.listState.observe(this){
         adapter.setList(it)
     }
    }
}