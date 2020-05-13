package ir.sbu.softwareengineering_proposal.ui.usersListForAdminFragment

import ir.sbu.softwareengineering_proposal.model.User

interface UserListForAdminContract {

    interface View{
        fun showProgressBar(show: Boolean)
        fun showToast(message: String)
        fun successfulLoad(userList: List<User>)
    }

    interface Presenter{
        fun getUsersFromServer(authToken: String, type: String? = null)
    }
}