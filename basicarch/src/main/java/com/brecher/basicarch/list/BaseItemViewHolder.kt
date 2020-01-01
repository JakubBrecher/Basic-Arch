package com.brecher.basicarch.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Jakub Brecher on 2019-12-20.
 */

class BaseItemViewHolder<ENTITY, CUSTOM_VIEW>(
    private val view: CUSTOM_VIEW,
    private val onItemClickListener: OnItemClickListener<ENTITY>?
) : RecyclerView.ViewHolder(view) where CUSTOM_VIEW : IListItem<ENTITY>, CUSTOM_VIEW : View {

    fun bind(entity: ENTITY) {
        view.setEntity(entity)
        onItemClickListener?.let { listener ->
            view.setOnClickListener {
                listener.onItemClick(entity)
            }
        }
    }
}