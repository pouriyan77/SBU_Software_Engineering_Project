package ir.sbu.softwareengineering_proposal.ui.professorListFragment

import ir.sbu.softwareengineering_proposal.model.Professor

interface ProfessorListContract {

    interface View {
        fun showToast(message: String)
        fun showProgressBar(show: Boolean)
        fun successfulSupervisorDefine()
        fun successfulRefereeDefine()
        fun successfulLoad(professorList: List<Professor>)
    }

    interface Presenter{
        fun requestDefiningSupervisor(
            authToken: String,
            studentId: Int,
            proposalId: Int,
            professorId: Int
        )
        fun requestDefiningReferees(
            authToken: String,
            refereeId1: Int,
            refereeId2: Int,
            proposalId: Int
        )
        fun requestProfessorList(authToken: String)
    }
}