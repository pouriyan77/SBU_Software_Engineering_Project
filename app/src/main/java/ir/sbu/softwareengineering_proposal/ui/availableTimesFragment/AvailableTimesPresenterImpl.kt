package ir.sbu.softwareengineering_proposal.ui.availableTimesFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.AddTimeResponse
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.TimeResponse
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AvailableTimesPresenterImpl(
    val view: AvailableTimesContract.View
): AvailableTimesContract.Presenter {

    override fun requestTimes(authToken: String) {
        val call = RetrofitBuilder.apiService.getProfessorTimes(
            PRE_TOKEN + authToken
        )

        call.enqueue(object : Callback<List<TimeResponse>> {
            override fun onFailure(call: Call<List<TimeResponse>>, t: Throwable) {
                view.showFullLoading(false)
                view.showToast(genericErrorStr)
            }

            override fun onResponse(
                call: Call<List<TimeResponse>>,
                response: Response<List<TimeResponse>>
            ) {
                if (response.isSuccessful){
                    val timesResponse = response.body()
                    if (timesResponse != null) {
                        view.successfulLoad(timesResponse)
                    }
                } else{
                    view.showToast(response.message())
                }
                view.showFullLoading(false)
            }


        })
    }

    override fun requestAddTime(authToken: String, day: Int, start: Int, end: Int) {
        val call = RetrofitBuilder.apiService.addFreeTime(
            PRE_TOKEN + authToken,
            day,
            start,
            end
        )

        call.enqueue(object : Callback<AddTimeResponse> {
            override fun onFailure(call: Call<AddTimeResponse>, t: Throwable) {
                view.showButtonLoading(false)
                view.showToast(genericErrorStr)
            }

            override fun onResponse(
                call: Call<AddTimeResponse>,
                response: Response<AddTimeResponse>
            ) {
                if (response.isSuccessful){
                    val timesResponse = response.body()
                    if (timesResponse != null) {
                        view.successfulLoad(timesResponse.timeList)
                    } else {
                        view.showToast(genericErrorStr)
                    }
                } else{
                    view.showToast(response.message())
                }
                view.showButtonLoading(false)
            }


        })
    }

}