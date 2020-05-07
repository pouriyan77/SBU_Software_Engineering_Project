package ir.sbu.softwareengineering_proposal.adapter.deskRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.model.DeskItem

class DeskRecyclerAdapter(private val itemsList: List<DeskItem>,
                          private val recyclerViewInteraction: RecyclerViewInteraction):
    RecyclerView.Adapter<RecyclerViewHolder<DeskItem>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<DeskItem> {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_desk_item_layout, parent, false)
        return DeskItemViewHolder(view, recyclerViewInteraction)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder<DeskItem>, position: Int) {
        holder.bind(itemsList[position])
    }
}