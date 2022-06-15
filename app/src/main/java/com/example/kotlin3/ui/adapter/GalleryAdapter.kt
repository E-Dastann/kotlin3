package com.example.kotlin3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin3.databinding.ItemImageBinding

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private var list = arrayListOf<String>()
    var selectedList = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            Glide.with(itemView).load(image).into(binding.imageView)

            binding.root.setOnClickListener {
                if (binding.selectionImage.isInvisible) {
                    binding.selectionImage.isVisible = true
                    selected(image)
                } else {
                    binding.selectionImage.isInvisible = true
                    isSelected(image)
                }
            }
        }

        private fun isSelected(image: String) {
            selectedList.remove(image)
        }

        private fun selected(image: String) {
            selectedList.add(image)
        }
    }

}