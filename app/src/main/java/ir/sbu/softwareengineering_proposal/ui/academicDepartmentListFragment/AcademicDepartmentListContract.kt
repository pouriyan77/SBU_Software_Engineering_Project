package ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment

import ir.sbu.softwareengineering_proposal.model.Major

interface AcademicDepartmentListContract {

    interface View{
        fun showProgressBar(show: Boolean)
        fun showToast(message: String)
        fun successfulMajorList(majorList: List<Major>)
    }

    interface Presenter{
        fun requestMajors(authToken: String)
    }
}