package ir.sbu.softwareengineering_proposal.ui.registerFragment

import ir.sbu.softwareengineering_proposal.api.requests.RegisterUserRequest

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