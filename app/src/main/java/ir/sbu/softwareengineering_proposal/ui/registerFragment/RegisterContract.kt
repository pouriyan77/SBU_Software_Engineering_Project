package ir.sbu.softwareengineering_proposal.ui.registerFragment

import ir.sbu.softwareengineering_proposal.api.RegisterUserRequest
import ir.sbu.softwareengineering_proposal.model.User
import ir.sbu.softwareengineering_proposal.session.SessionManager

interface RegisterContract {

    interface View{
        fun showToast(message: String)
        fun successfulRegister(userId: Int)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestRegister(registerUserRequest: RegisterUserRequest)
    }
}