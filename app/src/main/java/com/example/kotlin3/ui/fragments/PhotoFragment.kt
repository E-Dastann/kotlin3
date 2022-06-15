package com.example.kotlin3.ui.fragments

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin3.R
import com.example.kotlin3.base.BaseFragment
import com.example.kotlin3.databinding.FragmentPhotoBinding
import com.example.kotlin3.ui.adapter.GalleryAdapter


class PhotoFragment : BaseFragment<FragmentPhotoBinding>(R.layout.fragment_photo) {

    override val binding by viewBinding(FragmentPhotoBinding::bind)
    private val viewModel: SharedViewModel by activityViewModels()
    private val adapter = GalleryAdapter()
    private val list = arrayListOf<String>().apply {
        add("https://cdn.motor1.com/images/mgl/KWNNM/s1/mercedes-amg-e63-s-sedan-by-brabus.jpg")
        add("https://paultan.org/image/2021/09/2021-W213-Mercedes-AMG-E-63-S-4Matic-Malaysia-launch-official-1-630x330.jpg")
        add("https://www.topgear.com/sites/default/files/images/news-article/2017/10/1de2f02f1379bfb36bf5fef441ac28fa/01mercamge63tg.jpg")
    }

    override fun initViews() {
        super.initViews()
        initAdapter()
        adapter.setList(list)
    }

    private fun initAdapter() {
        binding.recyclerview.layoutManager = GridLayoutManager(context, 3)
        binding.recyclerview.adapter = adapter
    }

    override fun initListeners() {
        super.initListeners()
        binding.fabNext.setOnClickListener {
            viewModel.putImage(adapter.selectedList)
            findNavController().navigate(R.id.action_PhotoFragment_to_selectedFragment)
        }
    }


}