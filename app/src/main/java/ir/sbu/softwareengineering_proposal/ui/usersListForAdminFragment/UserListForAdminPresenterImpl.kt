package ir.sbu.softwareengineering_proposal.ui.usersListForAdminFragment

import ir.sbu.softwareengineering_proposal.api.RetrofitBuilder
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse
import ir.sbu.softwareengineering_proposal.api.responses.GetUsersResponse
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Student
import ir.sbu.softwareengineering_proposal.model.User
import ir.sbu.softwareengineering_proposal.utils.PRE_TOKEN
import ir.sbu.softwareengineering_proposal.utils.genericErrorStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListForAdminPresenterImpl(private val view: UserListForAdminContract.View):
    UserListForAdminContract.Presenter {

    override fun getUsersFromServer(authToken: String, type: String?) {
        val call = RetrofitBuilder.apiService.getAllUsersForAdmin(
            PRE_TOKEN + authToken, type)

        call.enqueue(object : Callback<GetUsersResponse>{
            override fun onFailure(call: Call<GetUsersResponse>, t: Throwable) {
                view.showProgressBar(false)
                view.showToast(genericErrorStr)
            }

            override fun onResponse(
                call: Call<GetUsersResponse>,
                response: Response<GetUsersResponse>
            ) {
                if (response.isSuccessful){
                    val getUsersResponse = response.body()
                    if (getUsersResponse != null) {
                        if (getUsersResponse.status == GenericResponse.SUCCESS_STATUS) {
                            val userList: MutableList<User> = mutableListOf()
                            getUsersResponse.studentList?.forEach {
                                userList.add(
                                    Student(
                                        it.stdId,
                                        it.studentNumber,
                                        it.type,
                                        it.grade,
                                        it.major,
                                        it.user.id,
                                        it.user.nationalCode,
                                        it.user.firstName,
                                        it.user.lastName,
                                        it.user.email,
                                        it.user.roleId,
                                        it.major != null
                                    )
                                )
                            }
                            getUsersResponse.professorList?.forEach {
                                userList.add(
                                    Professor(
                                        it.profId,
                                        it.level,
                                        it.major,
                                        listOf("یادگیری ماشین", "داده کاوی"),
                                        it.user.id,
                                        it.user.nationalCode,
                                        it.user.firstName,
                                        it.user.lastName,
                                        it.user.email,
                                        it.user.roleId,
                                        it.major != null
                                    )
                                )
                            }
                            view.successfulLoad(userList)
                        }else if (getUsersResponse.status == GenericResponse.FAILED_STATUS){
                            view.showToast(getUsersResponse.message)
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