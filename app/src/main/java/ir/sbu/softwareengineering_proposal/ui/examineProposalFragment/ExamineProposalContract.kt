package ir.sbu.softwareengineering_proposal.ui.examineProposalFragment

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface ExamineProposalContract {
    interface View{
        fun showToast(message: String)
        fun successfulLogin(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestLogin()
    }
}