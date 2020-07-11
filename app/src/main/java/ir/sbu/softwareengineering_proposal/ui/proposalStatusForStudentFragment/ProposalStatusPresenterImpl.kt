package ir.sbu.softwareengineering_proposal.ui.proposalStatusForStudentFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.ProposalStatusResponse
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProposalStatusPresenterImpl(
    val view: ProposalStatusContract.View
): ProposalStatusContract.Presenter {

    override fun requestProposalStatus(authToken: String, userId: Int) {
        val call = RetrofitBuilder.apiService.getProposalStatus(
            PRE_TOKEN + authToken,
            userId
        )

        call.enqueue(object : Callback<ProposalStatusResponse> {
            override fun onFailure(call: Call<ProposalStatusResponse>, t: Throwable) {
                view.showProgressBar(false)
                view.showToast(genericErrorStr)
            }

            override fun onResponse(
                call: Call<ProposalStatusResponse>,
                response: Response<ProposalStatusResponse>
            ) {
                if (response.isSuccessful){
                    val statusResponse = response.body()
                    if (statusResponse != null) {
                        view.successfulLoad(statusResponse)
                    }
                } else{
                    view.showToast(response.message())
                }
                view.showProgressBar(false)
            }


        })
    }


}