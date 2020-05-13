package ir.sbu.softwareengineering_proposal.ui.registerFragment

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface RegisterContract {

    interface View{
        fun showToast(message: String)
        fun successfulRegister(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestRegister(nationalCode: String, password: String)
    }
}