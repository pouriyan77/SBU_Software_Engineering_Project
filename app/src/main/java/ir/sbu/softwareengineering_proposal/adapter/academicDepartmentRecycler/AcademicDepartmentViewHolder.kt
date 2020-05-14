package ir.sbu.softwareengineering_proposal.adapter.academicDepartmentRecycler

import android.view.View
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.model.Major
import kotlinx.android.synthetic.main.recycler_academic_department_item_layout.view.*

class AcademicDepartmentViewHolder(itemView: View, interaction: RecyclerViewInteraction):
    RecyclerViewHolder<Major> (itemView, null) {

    init {
        itemView.setOnClickListener {
            interaction.onItemClickedListener(adapterPosition)
        }
    }

    override fun bind(item: Major) {
        itemView.AcademicDepartmentTextView.text = item.title
    }
}