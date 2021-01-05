package tech.developingdeveloper.datapersistenceretrofitexample.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tech.developingdeveloper.datapersistenceretrofitexample.data.model.Dog
import tech.developingdeveloper.datapersistenceretrofitexample.databinding.LayoutDogListItemBinding


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 03:06
 */

class DogAdapter : ListAdapter<Dog, DogAdapter.ViewHolder>(DogDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentDog = getItem(position)
        holder.bind(currentDog)
    }

    class ViewHolder private constructor(private val binding: LayoutDogListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(context: Context): ViewHolder {
                val layoutInflater = LayoutInflater.from(context)
                val binding = LayoutDogListItemBinding.inflate(layoutInflater)
                return ViewHolder(binding)
            }
        }

        fun bind(dog: Dog) {
            binding.dog = dog
            binding.executePendingBindings()
        }
    }

    class DogDiffUtils : DiffUtil.ItemCallback<Dog>() {
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem == newItem
        }
    }
}