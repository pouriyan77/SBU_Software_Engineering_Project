package ir.sbu.softwareengineering_proposal.ui.modifyStudentByAdmin

import ir.sbu.softwareengineering_proposal.session.SessionManager

interface ModifyStudentByAdminContract {

    interface View{
        fun showToast(message: String)
        fun successfulModify(session: SessionManager)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestLogin(nationalCode: String, password: String)
    }
}