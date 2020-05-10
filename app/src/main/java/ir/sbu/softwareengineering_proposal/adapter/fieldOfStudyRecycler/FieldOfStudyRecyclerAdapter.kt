package ir.sbu.softwareengineering_proposal.adapter.fieldOfStudyRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder

class FieldOfStudyRecyclerAdapter(private val itemsList: List<String>):
    RecyclerView.Adapter<RecyclerViewHolder<String>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<String> {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_study_field_item, parent, false)
        return FieldOfStudyItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder<String>, position: Int) {
        holder.bind(itemsList[position])
    }
}
