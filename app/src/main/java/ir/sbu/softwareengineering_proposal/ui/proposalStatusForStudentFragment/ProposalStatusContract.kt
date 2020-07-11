package ir.sbu.softwareengineering_proposal.ui.proposalStatusForStudentFragment

import ir.sbu.softwareengineering_proposal.api.responses.ProposalStatusResponse
import ir.sbu.softwareengineering_proposal.session.SessionManager

interface ProposalStatusContract {
    interface View{
        fun showToast(message: String)
        fun successfulLoad(proposalStatus: ProposalStatusResponse)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter {
        fun requestProposalStatus(
            authToken: String,
            userId: Int
        )
    }
}