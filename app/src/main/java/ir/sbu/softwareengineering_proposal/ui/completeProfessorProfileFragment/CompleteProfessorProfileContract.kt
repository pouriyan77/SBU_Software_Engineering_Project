package ir.sbu.softwareengineering_proposal.ui.completeProfessorProfileFragment

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface CompleteProfessorProfileContract {
    interface View{
        fun showToast(message: String)
        fun successfulLogin(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestLogin()
    }
}