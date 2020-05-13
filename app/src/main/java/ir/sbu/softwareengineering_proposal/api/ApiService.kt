package ir.sbu.softwareengineering_proposal.api

import ir.sbu.softwareengineering_proposal.api.responses.GetUsersResponse
import ir.sbu.softwareengineering_proposal.api.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("national_number") nationalNumber: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("get_professors_information")
    fun getAllProfessors(
        @Header("Authorization") authorization: String
    ): Call<LoginResponse>

    @GET("users")
    fun getAllUsersForAdmin(
        @Header("Authorization") authorization: String,
        @Query("type") type: String?
    ): Call<GetUsersResponse>


}