package ir.sbu.softwareengineering_proposal.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewHolder<T>
    (itemView : View, interaction : RecyclerViewInteraction? = null)
    : RecyclerView.ViewHolder(itemView)
{

    init {
        itemView.setOnClickListener {
            interaction?.onItemClickedListener(adapterPosition)
        }
    }

    abstract fun bind(item : T)
}