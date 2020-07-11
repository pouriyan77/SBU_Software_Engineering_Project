package ir.sbu.softwareengineering_proposal.adapter.finalProposalsRecycler

import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction

interface FinalProposalRecyclerInteraction: RecyclerViewInteraction {

    fun acceptClicked(position: Int)
    fun declineClicked(position: Int)
}