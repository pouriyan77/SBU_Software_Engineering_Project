package ir.sbu.softwareengineering_proposal.ui.proposalStatusForStudentFragment

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface ProposalStatusContract {
    interface View{
        fun showToast(message: String)
        fun successfulLogin(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter {

    }
}