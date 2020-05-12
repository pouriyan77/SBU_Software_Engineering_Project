package ir.sbu.softwareengineering_proposal.ui.loginActivity

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface LoginContract {

    interface View{
        fun showToast(message: String)
        fun successfulLogin(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestLogin(nationalCode: String, password: String)
    }

}