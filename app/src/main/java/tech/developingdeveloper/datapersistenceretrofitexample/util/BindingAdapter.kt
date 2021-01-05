package tech.developingdeveloper.datapersistenceretrofitexample.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tech.developingdeveloper.datapersistenceretrofitexample.R
import tech.developingdeveloper.datapersistenceretrofitexample.data.model.Dog
import tech.developingdeveloper.datapersistenceretrofitexample.ui.home.DogAdapter


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 02:58
 */

@BindingAdapter("setData")
fun setData(recyclerView: RecyclerView, dogs: List<Dog>?) {
    val adapter = recyclerView.adapter as DogAdapter
    adapter.submitList(dogs)
}

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_baseline_cloud_off_24)
            .into(imageView)

    }
}

@BindingAdapter("setStatus")
fun setStatus(imageView: ImageView, status: Status?) {
    when (status) {
        Status.DONE -> imageView.visibility = View.GONE
        Status.ERROR -> imageView.setImageResource(R.drawable.ic_baseline_cloud_off_24)
        Status.LOADING -> imageView.setImageResource(R.drawable.loading_animation)
    }
}