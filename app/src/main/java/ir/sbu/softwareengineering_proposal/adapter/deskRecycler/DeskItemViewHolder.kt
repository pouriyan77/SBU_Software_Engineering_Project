package ir.sbu.softwareengineering_proposal.adapter.deskRecycler

import android.view.View
import com.bumptech.glide.Glide
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.model.DeskItem
import kotlinx.android.synthetic.main.recycler_desk_item_layout.view.*

class DeskItemViewHolder(itemView: View, recyclerViewInteraction: RecyclerViewInteraction) :
    RecyclerViewHolder<DeskItem>(itemView, recyclerViewInteraction) {

    init {
        itemView.setOnClickListener {
            recyclerViewInteraction.onItemClickedListener(adapterPosition)
        }
    }

    override fun bind(item: DeskItem) {
        itemView.deskItemTitle.text = item.name
        Glide.with(itemView.context)
            .load(item.imageRes)
            .into(itemView.deskItemImage)
    }
}