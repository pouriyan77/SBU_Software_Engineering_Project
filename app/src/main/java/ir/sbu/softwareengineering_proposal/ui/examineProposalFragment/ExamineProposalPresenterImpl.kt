package ir.sbu.softwareengineering_proposal.ui.examineProposalFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExamineProposalPresenterImpl(private val view: ExamineProposalContract.View):
    ExamineProposalContract.Presenter {

    override fun requestExamine(
        authToken: String,
        status: String,
        message: String,
        proposalId: Int,
        beforeOrAfter: String
    ) {
        val call = RetrofitBuilder.apiService.examineProposal(
            PRE_TOKEN + authToken,
            status,
            message,
            proposalId,
            beforeOrAfter
        )

        call.enqueue(object: Callback<GenericResponse>{
            override fun onFailure(call: Call<GenericResponse>, t: Throwable) {
                view.showProgressBar(false)
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
                            view.successfulSubmit()
                        }else if (examineResponse.status == GenericResponse.FAILED_STATUS){
                            view.showToast(examineResponse.message)
                        }
                    }
                } else{
                    view.showToast(response.message())
                }
                view.showProgressBar(false)
            }

        })
    }

}