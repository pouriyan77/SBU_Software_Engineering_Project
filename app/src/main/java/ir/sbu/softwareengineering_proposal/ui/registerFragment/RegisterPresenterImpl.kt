package ir.sbu.softwareengineering_proposal.ui.registerFragment

import ir.sbu.softwareengineering_proposal.api.RegisterUserRequest
import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.RegisterResponse
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenterImpl(private val view: RegisterContract.View) : RegisterContract.Presenter {
    override fun requestRegister(registerUserRequest: RegisterUserRequest) {
        val call = RetrofitBuilder.apiService.register(registerUserRequest)

        call.enqueue(object : Callback<RegisterResponse> {
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                view.showToast(genericErrorStr)
                view.showProgressBar(false)
            }

            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null) {
                        if (registerResponse.status == GenericResponse.SUCCESS_STATUS) {
                            view.successfulRegister(registerResponse.userId)
                        } else {
                            view.showToast(registerResponse.message)
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