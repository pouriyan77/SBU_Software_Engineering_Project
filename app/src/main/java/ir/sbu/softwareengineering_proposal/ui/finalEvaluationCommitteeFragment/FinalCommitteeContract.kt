package ir.sbu.softwareengineering_proposal.ui.finalEvaluationCommitteeFragment

import ir.sbu.softwareengineering_proposal.model.Proposal

interface FinalCommitteeContract {

    interface View {
        fun showToast(message: String)
        fun showFullLoading(show: Boolean)
        fun successfulLoad(proposals: List<Proposal>)
        fun successfulAcceptOrDecline()
    }

    interface Presenter {
        fun requestAllProposals(authToken: String)
        fun requestAcceptOrDecline(authToken: String, proposalId: Int, shoraResponse: String)
    }
}