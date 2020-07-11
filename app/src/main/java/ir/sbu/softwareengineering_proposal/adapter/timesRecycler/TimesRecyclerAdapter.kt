package ir.sbu.softwareengineering_proposal.adapter.timesRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.api.responses.TimeResponse

class TimesRecyclerAdapter(private var itemsList: List<TimeResponse>):
    RecyclerView.Adapter<RecyclerViewHolder<TimeResponse>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<TimeResponse> {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_available_times_layout, parent, false)
        return TimeItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder<TimeResponse>, position: Int) {
        holder.bind(itemsList[position])
    }

    fun submitList(times: List<TimeResponse>) {
        itemsList = times
        notifyDataSetChanged()
    }
}
