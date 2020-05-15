package ir.sbu.softwareengineering_proposal.ui.professorListFragment

import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Student

interface ProfessorListContract {

    interface View {
        fun showToast(message: String)
        fun showProgressBar(show: Boolean)
        fun successfulDefine()
        fun successfulLoad(professorList: List<Professor>)
    }

    interface Presenter{
        fun requestDefiningSupervisor(authToken: String, studentId: Int, proposalId: Int, professorId: Int)
        fun requestProfessorList(authToken: String)
    }
}