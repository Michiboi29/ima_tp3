package com.example.tp3.ui.main

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3.MainActivity
import com.example.tp3.dataClasses.Brand
import com.example.tp3.databinding.FragmentOffre1Binding
import com.example.tp3.ui.main.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<Brand>,
    private val onItemClickListener: ((Int) -> Unit)? = null)
    : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    public fun getItem(position: Int): Brand {
        return values[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentOffre1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClickListener
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id.toString()
        holder.contentView.text = item.name
    }

    override fun getItemCount(): Int = values.size



    inner class ViewHolder(private val binding: FragmentOffre1Binding, onItemClickListener: ((Int) -> Unit)?) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }

        init {
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(adapterPosition)
            }
        }
    }
}

