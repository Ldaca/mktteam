

package com.ldaca.app.ready.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ldaca.app.ready.R
import com.ldaca.app.ready.data.domain.Contact
import com.ldaca.app.ready.databinding.ItemPostBinding

class PostsAdapter(val listener: (Contact)->Unit): ListAdapter<Contact, PostsAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(if (viewType == 0 ) R.layout.item_post else R.layout.item_post_image, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int) = if (getItem(position).imagePath.isEmpty()) 0 else 1


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemPostBinding.bind(itemView)

        fun bind(item: Contact) = with(binding) {
            dateTime.text = item.createAt
            if (item.imagePath.isNotEmpty()) {
                Glide.with(itemView.context)
                    .load(item.imagePath)
                    .centerCrop()
                    .into(imgPost)
            }
            itemView.setOnClickListener { listener(item) }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }
}