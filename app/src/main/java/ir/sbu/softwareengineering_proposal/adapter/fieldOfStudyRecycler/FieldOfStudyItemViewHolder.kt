package ir.sbu.softwareengineering_proposal.adapter.fieldOfStudyRecycler

import android.view.View
import com.bumptech.glide.Glide
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.model.DeskItem
import kotlinx.android.synthetic.main.recycler_desk_item_layout.view.*
import kotlinx.android.synthetic.main.recycler_study_field_item.view.*

class FieldOfStudyItemViewHolder(itemView: View) :
    RecyclerViewHolder<String>(itemView, null) {

    override fun bind(item: String) {
        itemView.fieldOfStudyTextView.text = item
    }
}