package ir.sbu.softwareengineering_proposal.api

import ir.sbu.softwareengineering_proposal.api.requests.ModifyUserByAdminRequest
import ir.sbu.softwareengineering_proposal.api.requests.ProfAndStudentModifyDetails
import ir.sbu.softwareengineering_proposal.api.requests.RegisterUserRequest
import ir.sbu.softwareengineering_proposal.api.responses.*
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

    @POST("register")
    fun register(
        @Body registerUserRequest: RegisterUserRequest
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("modify_profile")
    fun modifyUserByHimSelf(
        @Header("Authorization") authorization: String,
        @Field("email") email: String,
        @Field("password") newPassword: String?
    ): Call<ModifyUserByHimSelfResponse>

    @GET("major")
    fun getAllMajors(
        @Header("Authorization") authorization: String
    ): Call<MajorsResponse>

    @POST("modify_user")
    fun modifyUserByAdmin(
        @Header("Authorization") authorization: String,
        @Body modifyUserByAdminRequest: ModifyUserByAdminRequest,
        @Header("Accept") accept: String = "application/json"
    ): Call<GenericResponse>

    @POST("get_proposals_information")
    fun getAllProposals(
        @Header("Authorization") authorization: String
    ): Call<GetProposalsResponse>

    @POST("get_assigned_proposal")
    fun getAssignedProposals(
        @Header("Authorization") authorization: String
    ): Call<GetProposalsResponse>
}