package com.example.gurushotsdemo.presentation.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.gurushotsdemo.databinding.ViewPhotoBinding
import com.example.gurushotsdemo.presentation.getPhotoLink

class ListPhotoAdapter(
    private val onItemClick: (photoId: String) -> Unit
) : ListAdapter<String, ListPhotoAdapter.PhotoViewHolder>(DiffCallback) {

    inner class PhotoViewHolder(private val binding: ViewPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val circularProgressDrawable =
            CircularProgressDrawable(binding.root.context).apply {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }

        fun bindItem(photoId: String) {

            binding.ivPhoto.setOnClickListener {
                onItemClick(photoId)
            }

            Glide.with(binding.root.context)
                .load(getPhotoLink(photoId))
                .placeholder(circularProgressDrawable)
                .into(binding.ivPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(ViewPhotoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bindItem(photo)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}