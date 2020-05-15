package ir.sbu.softwareengineering_proposal.ui.proposalListFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.GetProposalsResponse
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.model.Student
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProposalListPresenterImpl(
    private val view: ProposalListContract.View
): ProposalListContract.Presenter {

    override fun requestAllProposals(authToken: String) {
        val call = RetrofitBuilder.apiService.getAllProposals(PRE_TOKEN + authToken)

        call.enqueue(object : Callback<GetProposalsResponse> {
            override fun onFailure(call: Call<GetProposalsResponse>, t: Throwable) {
                view.showToast(genericErrorStr)
                view.showProgressBar(false)
            }

            override fun onResponse(
                call: Call<GetProposalsResponse>,
                response: Response<GetProposalsResponse>
            ) {
                if (response.isSuccessful) {
                    val proposalsResponse = response.body()
                    if (proposalsResponse != null) {
                        if (proposalsResponse.status == GenericResponse.SUCCESS_STATUS) {
                            view.successfulLoad(handleResponse(proposalsResponse))
                        } else {
                            view.showToast(proposalsResponse.message)
                        }
                    }
                } else {
                    view.showToast(response.message())
                }
                view.showProgressBar(false)
            }

        })
    }

    override fun requestAssignedProposals(authToken: String) {

        val call = RetrofitBuilder.apiService.getAssignedProposals(PRE_TOKEN + authToken)

        call.enqueue(object : Callback<GetProposalsResponse> {
            override fun onFailure(call: Call<GetProposalsResponse>, t: Throwable) {
                view.showToast(genericErrorStr)
                view.showProgressBar(false)
            }

            override fun onResponse(
                call: Call<GetProposalsResponse>,
                response: Response<GetProposalsResponse>
            ) {
                if (response.isSuccessful) {
                    val proposalsResponse = response.body()
                    if (proposalsResponse != null) {
                        if (proposalsResponse.status == GenericResponse.SUCCESS_STATUS) {
                            view.successfulLoad(handleResponse(proposalsResponse))
                        } else {
                            view.showToast(proposalsResponse.message)
                        }
                    }
                } else {
                    view.showToast(response.message())
                }
                view.showProgressBar(false)
            }

        })
    }

    private fun handleResponse(proposalsResponse: GetProposalsResponse): List<Proposal> {
        val proposalList: MutableList<Proposal> = mutableListOf()
        proposalsResponse.proposalList.forEach {
            val proposal =
                Proposal(
                    it.proposalId,
                    it.persianTitle,
                    it.persianKeyword,
                    it.englishTitle,
                    it.englishKeyWords,
                    it.proposalType,
                    owner = Student(
                        it.student.stdId,
                        it.student.studentNumber,
                        it.student.type,
                        it.student.grade,
                        it.student.major,
                        it.student.user.id,
                        it.student.user.nationalCode,
                        it.student.user.firstName,
                        it.student.user.lastName,
                        it.student.user.email,
                        it.student.user.roleId,
                        it.student.major != null
                    ),
                    supervisor = null
                )
            if (it.supervisor != null) {
                proposal.supervisor = Professor(
                    it.supervisor.profId,
                    it.supervisor.level,
                    it.supervisor.major,
                    listOf(),
                    it.supervisor.user.id,
                    it.supervisor.user.nationalCode,
                    it.supervisor.user.firstName,
                    it.supervisor.user.lastName,
                    it.supervisor.user.email,
                    it.supervisor.user.roleId,
                    it.supervisor.major != null
                )
            }
            proposalList.add(proposal)
        }
        return proposalList
    }

}