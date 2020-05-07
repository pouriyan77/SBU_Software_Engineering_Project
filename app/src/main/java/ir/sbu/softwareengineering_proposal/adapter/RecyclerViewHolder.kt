package com.pand_app.asyab.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewHolder<T>
    (itemView : View, interaction : RecyclerViewInteraction? = null)
    : RecyclerView.ViewHolder(itemView)
{
    abstract fun bind(item : T)
}