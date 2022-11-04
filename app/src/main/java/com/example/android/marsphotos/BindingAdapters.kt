package com.example.android.marsphotos

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.android.marsphotos.network.MarsPhoto
import com.example.android.marsphotos.overview.MarsApiStatus
import com.example.android.marsphotos.overview.PhotoGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        imgView.context?.let {
            Glide.with(imgView.context)
              .load(imgUrl)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .into(imgView)


        }


        /*val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri){
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }*/
    }
}
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<MarsPhoto>?) {
    Log.d("MAAZ","HERE1")
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("marsApiStatus")
fun bindStatus(img:ImageView,status:MarsApiStatus)
{
    when(status)
    {
        MarsApiStatus.LOADING->{
            img.visibility= View.VISIBLE
            img.setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR->{
            img.visibility=View.VISIBLE
            img.setImageResource(R.drawable.ic_connection_error)
        }
        MarsApiStatus.DONE->{
            img.visibility=View.GONE

        }
    }
}