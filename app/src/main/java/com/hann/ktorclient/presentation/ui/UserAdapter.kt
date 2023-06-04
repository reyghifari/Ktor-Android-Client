package com.hann.ktorclient.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hann.ktorclient.R
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.databinding.ItemLayoutUserBinding
import java.util.ArrayList

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var listData = ArrayList<UserResponse>()
    var onItemClick: ((UserResponse) -> Unit)? = null

    fun setData(newListData: List<UserResponse>?) {
        if (newListData == null) return
        val diffResult = DiffUtil.calculateDiff(MyDiffUtil(listData, newListData))
        listData.clear()
        listData.addAll(newListData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout_user, parent, false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemLayoutUserBinding.bind(itemView)

        fun bind(data: UserResponse) {
            with(binding){
                Glide.with(itemView.context)
                    .load(data.avatarUrl)
                    .into(imageViewUserLayout)
                tvUserLayout.text = data.login
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    class MyDiffUtil(private val oldList: List<UserResponse>, private val newList: List<UserResponse>): DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}