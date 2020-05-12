package ir.sbu.softwareengineering_proposal.api

import ir.sbu.softwareengineering_proposal.api.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("national_number") nationalNumber: String,
                @Field("password") password: String): Call<LoginResponse>
}