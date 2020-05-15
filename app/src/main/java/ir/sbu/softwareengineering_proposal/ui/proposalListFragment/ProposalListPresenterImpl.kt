package ir.sbu.softwareengineering_proposal.ui.proposalListFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.GetProposalsResponse
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

        call.enqueue(object : Callback<GetProposalsResponse>{
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
//                            view.successfulLoad(proposalsResponse.proposalList)
                        } else {
                            view.showToast(proposalsResponse.message)
                        }
                    }
                }else{
                    view.showToast(response.message())
                }
                view.showProgressBar(false)
            }

        })
    }

    override fun requestAssignedProposals(authToken: String) {

        val call = RetrofitBuilder.apiService.getAssignedProposals(PRE_TOKEN + authToken)

        call.enqueue(object : Callback<GetProposalsResponse>{
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

                        } else {
                            view.showToast(proposalsResponse.message)
                        }
                    }
                }else{
                    view.showToast(response.message())
                }
                view.showProgressBar(false)
            }

        })
    }


}