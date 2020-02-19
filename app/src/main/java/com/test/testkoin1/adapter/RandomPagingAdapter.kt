package com.test.testkoin1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.testkoin1.api.data.randomuser.RandomUser
import com.test.testkoin1.databinding.ItemUserInfoBinding

class RandomPagingAdapter : PagedListAdapter<RandomUser, RandomPagingAdapter.RandomPagingAdapterViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomPagingAdapterViewHolder =
        RandomPagingAdapterViewHolder(ItemUserInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<RandomUser>() {
            override fun areItemsTheSame(oldItem: RandomUser, newItem: RandomUser): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: RandomUser, newItem: RandomUser): Boolean =
                oldItem.uLogin.lUserName == newItem.uLogin.lUserName
        }
    }

    override fun onBindViewHolder(holder: RandomPagingAdapterViewHolder, position: Int) {
        val randomUser = getItem(position)
        val binding = holder.binding

        if (randomUser != null)
            binding.randomUser = randomUser
    }

    class RandomPagingAdapterViewHolder(val binding: ItemUserInfoBinding) : RecyclerView.ViewHolder(binding.root)
}