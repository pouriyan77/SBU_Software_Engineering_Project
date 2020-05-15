package ir.sbu.softwareengineering_proposal.ui.proposalListFragment

import ir.sbu.softwareengineering_proposal.model.Proposal

interface ProposalListContract {

    interface View{
        fun showToast(message: String)
        fun successfulLoad(proposalList: List<Proposal>)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestAllProposals(authToken: String)
        fun requestAssignedProposals(authToken: String)
    }
}