package ir.sbu.softwareengineering_proposal.adapter.academicDepartmentRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.model.Major

class AcademicDepartmentRecyclerAdapter(
    private val itemList: List<Major>,
    private val interaction: RecyclerViewInteraction) :
    RecyclerView.Adapter<RecyclerViewHolder<Major>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerViewHolder<Major> {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_academic_department_item_layout, parent, false
        )
        return AcademicDepartmentViewHolder(view, interaction)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder<Major>, position: Int) {
        holder.bind(itemList[position])
    }


}