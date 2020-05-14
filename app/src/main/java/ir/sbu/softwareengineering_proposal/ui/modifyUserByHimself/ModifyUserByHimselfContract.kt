package ir.sbu.softwareengineering_proposal.ui.modifyUserByHimself

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface ModifyUserByHimselfContract {
    interface View {
        fun showToast(message: String)
        fun showProgressBar(show: Boolean)
        fun successfulModify(newEmail: String)
    }

    interface Presenter{
        fun requestModify(authToken: String, email: String, password: String?)
    }
}