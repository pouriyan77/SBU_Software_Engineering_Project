package ir.sbu.softwareengineering_proposal.ui.finalEvaluationCommitteeFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.ProposalResponse
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.model.Student
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinalEvaluationCommitteePresenterImpl(
    val view: FinalCommitteeContract.View
): FinalCommitteeContract.Presenter {

    override fun requestAllProposals(authToken: String) {
        val call = RetrofitBuilder.apiService.getAllAcceptedProposals(
            PRE_TOKEN + authToken
        )

        call.enqueue(object : Callback<List<ProposalResponse>> {
            override fun onFailure(call: Call<List<ProposalResponse>>, t: Throwable) {
                view.showFullLoading(false)
                view.showToast(genericErrorStr)
            }

            override fun onResponse(
                call: Call<List<ProposalResponse>>,
                response: Response<List<ProposalResponse>>
            ) {
                if (response.isSuccessful){
                    val proposalResponse = response.body()
                    if (proposalResponse != null) {
                        view.successfulLoad(handleResponse(proposalResponse))
                    } else {
                        view.showToast(genericErrorStr)
                    }
                } else{
                    view.showToast(response.message())
                }
                view.showFullLoading(false)
            }

        })
    }

    override fun requestAcceptOrDecline(authToken: String, proposalId: Int, shoraResponse: String) {
        val call = RetrofitBuilder.apiService.examineProposal(
            PRE_TOKEN + authToken,
            null,
            null,
            proposalId,
            null,
            shoraResponse
        )

        call.enqueue(object: Callback<GenericResponse>{
            override fun onFailure(call: Call<GenericResponse>, t: Throwable) {
//                view.showProgressBar(false)
                view.showToast(genericErrorStr)
            }

            override fun onResponse(
                call: Call<GenericResponse>,
                response: Response<GenericResponse>
            ) {
                if (response.isSuccessful){
                    val examineResponse = response.body()
                    if (examineResponse != null) {
                        if (examineResponse.status == GenericResponse.SUCCESS_STATUS) {
                            view.successfulAcceptOrDecline()
                        }else if (examineResponse.status == GenericResponse.FAILED_STATUS){
                            view.showToast(examineResponse.message)
                        }
                    }
                } else{
                    view.showToast(response.message())
                }
//                view.showProgressBar(false)
            }

        })
    }

    private fun handleResponse(oldProposalList: List<ProposalResponse>): List<Proposal> {
        val proposalList: MutableList<Proposal> = mutableListOf()
        oldProposalList.forEach {
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

