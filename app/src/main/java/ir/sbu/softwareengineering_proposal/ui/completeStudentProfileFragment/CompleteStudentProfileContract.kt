package ir.sbu.softwareengineering_proposal.ui.completeStudentProfileFragment

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface CompleteStudentProfileContract {
    interface View{
        fun showToast(message: String)
        fun successfulLogin(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestLogin()
    }
}