package ir.sbu.softwareengineering_proposal.ui.loginActivity

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse.Companion.FAILED_STATUS
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse.Companion.SUCCESS_STATUS
import ir.sbu.softwareengineering_proposal.api.responses.LoginResponse
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenterImpl(private val view: LoginContract.View): LoginContract.Presenter {

    override fun requestLogin(nationalCode: String, password: String) {
        val call = RetrofitBuilder.apiService.login(nationalCode, password)
        call.enqueue(object : Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.showToast(genericErrorStr)
                view.showProgressBar(false)
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    val loginResponse = response.body()
                    if (loginResponse != null){
                        if (loginResponse.status == SUCCESS_STATUS){
                            val sessionManager = SessionManager(
                                loginResponse.authToken, loginResponse.user)
                            view.successfulLogin(sessionManager)
                        }else if (loginResponse.status == FAILED_STATUS){
                            view.showToast(loginResponse.message)
                        }
                    }
                }else {
                    view.showToast(response.message())
                }
                view.showProgressBar(false)
            }

        })
    }


}