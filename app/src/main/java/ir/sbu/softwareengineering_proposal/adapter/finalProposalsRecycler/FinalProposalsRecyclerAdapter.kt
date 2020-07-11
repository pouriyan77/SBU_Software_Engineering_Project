package ir.sbu.softwareengineering_proposal.adapter.finalProposalsRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.api.responses.TimeResponse
import ir.sbu.softwareengineering_proposal.model.Proposal

class FinalProposalsRecyclerAdapter(
    private val itemsList: List<Proposal>,
    private val interaction: FinalProposalRecyclerInteraction

): RecyclerView.Adapter<RecyclerViewHolder<Proposal>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<Proposal> {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_proposal_admin_check, parent, false)
        return FinalProposalsItemViewHolder(view, interaction)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder<Proposal>, position: Int) {
        holder.bind(itemsList[position])
    }
}
