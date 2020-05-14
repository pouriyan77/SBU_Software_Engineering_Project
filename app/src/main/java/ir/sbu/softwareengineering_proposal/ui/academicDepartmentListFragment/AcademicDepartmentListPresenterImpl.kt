package ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.MajorsResponse
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AcademicDepartmentListPresenterImpl(val view: AcademicDepartmentListContract.View):
    AcademicDepartmentListContract.Presenter {

    override fun requestMajors(authToken: String) {
        val call = RetrofitBuilder.apiService.getAllMajors(PRE_TOKEN + authToken)

        call.enqueue(object : Callback<MajorsResponse>{
            override fun onFailure(call: Call<MajorsResponse>, t: Throwable) {
                view.showToast(genericErrorStr)
                view.showProgressBar(false)
            }

            override fun onResponse(
                call: Call<MajorsResponse>,
                response: Response<MajorsResponse>
            ) {
                if (response.isSuccessful) {
                    val majorsResponse = response.body()
                    if (majorsResponse != null) {
                        if (majorsResponse.status == GenericResponse.SUCCESS_STATUS) {
                            view.successfulMajorList(majorsResponse.majorList)
                        } else {
                            view.showToast(majorsResponse.message)
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