package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.requests.ModifyUserByAdminRequest
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModifyAndCompleteUserPresenterImpl(
    private val view: ModifyAndCompleteUserContract.View
): ModifyAndCompleteUserContract.Presenter {

    override fun requestModify(
        authToken: String,
        modifyUserByAdminRequest: ModifyUserByAdminRequest
    ) {
        val call = RetrofitBuilder.apiService.modifyUserByAdmin(
            PRE_TOKEN + authToken, modifyUserByAdminRequest)

        call.enqueue(object : Callback<GenericResponse>{
            override fun onFailure(call: Call<GenericResponse>, t: Throwable) {
                view.showToast(genericErrorStr)
                view.showProgressBar(false)
            }

            override fun onResponse(
                call: Call<GenericResponse>,
                response: Response<GenericResponse>
            ) {
                if (response.isSuccessful) {
                    val modifyResponse = response.body()
                    if (modifyResponse != null) {
                        if (modifyResponse.status == GenericResponse.SUCCESS_STATUS) {
                            view.successfulModify()
                        } else {
                            view.showToast(modifyResponse.message)
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