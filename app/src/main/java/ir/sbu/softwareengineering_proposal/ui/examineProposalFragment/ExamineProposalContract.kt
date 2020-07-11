package ir.sbu.softwareengineering_proposal.ui.examineProposalFragment

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface ExamineProposalContract {
    interface View{
        fun showToast(message: String)
        fun successfulSubmit()
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestExamine(
            authToken: String,
            status: String,
            message: String,
            proposalId: Int,
            beforeOrAfter: String
        )
    }
}