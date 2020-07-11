package ir.sbu.softwareengineering_proposal.adapter.finalProposalsRecycler

import android.view.View
import androidx.core.content.ContextCompat
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.api.responses.TimeResponse
import ir.sbu.softwareengineering_proposal.model.Proposal
import kotlinx.android.synthetic.main.recycler_available_times_layout.view.*
import kotlinx.android.synthetic.main.recycler_proposal_admin_check.view.*
import java.util.*

class FinalProposalsItemViewHolder(itemView: View, interaction: RecyclerViewInteraction) :
    RecyclerViewHolder<Proposal>(itemView, interaction) {

    private val proposalNameTextView = itemView.proposalNameTextView
    private val proposalOwner = itemView.studentNameProposalTextView
    private val acceptBtn = itemView.acceptBtn
    private val declineBtn = itemView.declineBtn

    init {
        interaction as FinalProposalRecyclerInteraction
        acceptBtn.setOnClickListener {
            interaction.acceptClicked(adapterPosition)
        }

        declineBtn.setOnClickListener {
            interaction.declineClicked(adapterPosition)
        }
    }

    override fun bind(item: Proposal) {
        proposalNameTextView.text = item.persianTitle
        proposalOwner.text = String.format(
            itemView.context.getString(
                R.string.fullNameStr,
                item.owner.firstName,
                item.owner.lastName
            )
        )
    }
}