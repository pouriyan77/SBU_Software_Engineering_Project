package ir.sbu.softwareengineering_proposal.ui.professorListFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.ProfessorsResponse
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfessorListPresenterImpl(private val view: ProfessorListContract.View
): ProfessorListContract.Presenter {


    override fun requestDefiningSupervisor(
        authToken: String,
        studentId: Int,
        proposalId: Int,
        professorId: Int
    ) {

    }

    override fun requestProfessorList(authToken: String) {
        val call = RetrofitBuilder.apiService.getAllProfessors(PRE_TOKEN + authToken)

        call.enqueue(object : Callback<ProfessorsResponse> {
            override fun onFailure(call: Call<ProfessorsResponse>, t: Throwable) {
                view.showProgressBar(false)
                view.showToast(genericErrorStr)
            }

            override fun onResponse(
                call: Call<ProfessorsResponse>,
                response: Response<ProfessorsResponse>
            ) {
                if (response.isSuccessful){
                    val getProfessorsResponse = response.body()
                    if (getProfessorsResponse != null) {
                        if (getProfessorsResponse.status == GenericResponse.SUCCESS_STATUS) {
                            val professorList: MutableList<Professor> = mutableListOf()
                            getProfessorsResponse.professorList.forEach {
                                val professor = Professor(
                                    it.profId,
                                    it.level,
                                    it.major,
                                    listOf("هوش مصنوعی", "یادگیری ماشین", "یادگیری عمیق"),
                                    it.user.id,
                                    it.user.nationalCode,
                                    it.user.firstName,
                                    it.user.lastName,
                                    it.user.email,
                                    it.user.roleId,
                                    it.major != null
                                )
                                professorList.add(professor)
                            }
                            view.successfulLoad(professorList)
                        }else if (getProfessorsResponse.status == GenericResponse.FAILED_STATUS){
                            view.showToast(getProfessorsResponse.message)
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