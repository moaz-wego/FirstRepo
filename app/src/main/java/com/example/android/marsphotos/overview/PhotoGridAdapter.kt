package com.example.android.marsphotos.overview

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.marsphotos.R
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter : ListAdapter<MarsPhoto,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    var counter=0;
    class MarsPhotoViewHolder(private var binding: GridViewItemBinding
    ): RecyclerView.ViewHolder(binding.root)
    {

        fun bind(MarsPhoto: MarsPhoto) {

            binding.photo = MarsPhoto
            binding.executePendingBindings()
            //Glide.with(binding.root.context)
              //  .load(MarsPhoto.imgSrcUrl)
                //.placeholder(R.drawable.loading_animation)
                //.error(R.drawable.ic_broken_image)
                //.into(binding.marsImage)

        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            Log.d("MAAZ"," in ITEM SAME")
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            Log.d("MAAZ"," in CONTENT SAME")
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.MarsPhotoViewHolder {
        Log.d("MAAZ","$counter in Create")
        counter++
         return MarsPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        Log.d("MAAZ"," in Bind")
        holder.bind(marsPhoto)
    }


}