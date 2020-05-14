package ir.sbu.softwareengineering_proposal.ui.modifyUserByHimself

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.ModifyUserByHimSelfResponse
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModifyUserByHimselfPresenterImpl(private val view: ModifyUserByHimselfContract.View)
    :ModifyUserByHimselfContract.Presenter {

    override fun requestModify(authToken: String, email: String, password: String?) {
        val call = RetrofitBuilder.apiService.modifyUserByHimSelf(
            PRE_TOKEN + authToken, email, password
        )

        call.enqueue(object : Callback<ModifyUserByHimSelfResponse>{
            override fun onFailure(call: Call<ModifyUserByHimSelfResponse>, t: Throwable) {
                view.showToast(genericErrorStr)
                view.showProgressBar(false)
            }

            override fun onResponse(
                call: Call<ModifyUserByHimSelfResponse>,
                response: Response<ModifyUserByHimSelfResponse>
            ) {
                if (response.isSuccessful) {
                    val modifyResponse = response.body()
                    if (modifyResponse != null) {
                        if (modifyResponse.status == GenericResponse.SUCCESS_STATUS) {
                            view.successfulModify(modifyResponse.newEmail)
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