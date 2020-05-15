package ir.sbu.softwareengineering_proposal.ui.uploadProposalFragment

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface UploadProposalContract {
    interface View{
        fun showToast(message: String)
        fun successfulLogin(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestLogin()
    }
}