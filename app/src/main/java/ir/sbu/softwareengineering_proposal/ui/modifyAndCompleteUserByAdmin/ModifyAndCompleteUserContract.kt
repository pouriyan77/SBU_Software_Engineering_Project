package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin

import ir.sbu.softwareengineering_proposal.api.requests.ModifyUserByAdminRequest

interface ModifyAndCompleteUserContract {

    interface View{
        fun showToast(message: String)
        fun successfulModify()
        fun showProgressBar(show: Boolean)
    }

    interface Presenter{
        fun requestModify(authToken: String, modifyUserByAdminRequest: ModifyUserByAdminRequest)
    }
}