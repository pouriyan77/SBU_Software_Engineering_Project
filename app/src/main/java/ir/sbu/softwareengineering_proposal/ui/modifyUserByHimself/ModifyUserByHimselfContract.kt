package ir.sbu.softwareengineering_proposal.ui.modifyUserByHimself

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface ModifyUserByHimselfContract {
    interface View {
        fun showToast(message: String)
        fun showProgressBar(show: Boolean)
        fun successfulModify(session: SessionManager)
    }

    interface Presenter{
        fun requestLogin(nationalCode: String, password: String)
    }
}