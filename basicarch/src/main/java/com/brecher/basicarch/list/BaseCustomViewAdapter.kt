package com.brecher.basicarch.list

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Jakub Brecher.
 */
abstract class BaseCustomViewAdapter<ENTITY, CUSTOM_VIEW>(
    private val data: MutableList<ENTITY>,
    private val onItemClickListener: OnItemClickListener<ENTITY>?
) : RecyclerView.Adapter<BaseItemViewHolder<ENTITY, CUSTOM_VIEW>>() where CUSTOM_VIEW : IListItem<ENTITY>, CUSTOM_VIEW : View {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseItemViewHolder<ENTITY, CUSTOM_VIEW> {
        return BaseItemViewHolder(createCustomView(parent.context), onItemClickListener)
    }

    override fun onBindViewHolder(holder: BaseItemViewHolder<ENTITY, CUSTOM_VIEW>, position: Int) {
        holder.bind(data[position])
    }

    fun addItems(items: List<ENTITY>) {
        val size = data.size
        data.addAll(items)
        notifyItemRangeChanged(size, size + data.size)
    }

    fun clearItems() {
        data.clear()
        notifyDataSetChanged()
    }

    abstract fun createCustomView(context: Context): CUSTOM_VIEW
}