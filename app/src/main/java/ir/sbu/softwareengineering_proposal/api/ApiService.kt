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

    @POST("get_professors_information")
    fun getAllProfessors(
        @Header("Authorization") authorization: String
    ): Call<ProfessorsResponse>

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

    @FormUrlEncoded
    @POST("define_supervisor")
    fun defineSupervisor(
        @Header("Authorization") authorization: String,
        @Field("student_id") studentId: Int,
        @Field("professor_id") supervisorId: Int,
        @Field("proposal_id") proposalId: Int,
        @Header("Accept") accept: String = "application/json"
    ): Call<GenericResponse>

    @FormUrlEncoded
    @POST("choose_judge")
    fun defineReferees(
        @Header("Authorization") authorization: String,
        @Field("judge1_id") refereeId1: Int,
        @Field("judge2_id") refereeId2: Int,
        @Field("proposal_id") proposalId: Int,
        @Header("Accept") accept: String = "application/json"
    ): Call<GenericResponse>

    @FormUrlEncoded
    @POST("judge_proposal")
    fun examineProposal(
        @Header("Authorization") authorization: String,
        @Field("judge_response") status: String?,
        @Field("judge_message") message: String?,
        @Field("proposal_id") proposalId: Int,
        @Field("flag") beforeOrAfter: String?,
        @Field("shora_response") shoraRes: String? = null,
        @Header("Accept") accept: String = "application/json"
    ): Call<GenericResponse>

    @GET("get_proposal_result")
    fun getProposalStatus(
        @Header("Authorization") authorization: String,
        @Query("user_id") userId: Int
    ): Call<ProposalStatusResponse>

    @GET("get_times")
    fun getProfessorTimes(
        @Header("Authorization") authorization: String
    ): Call<List<TimeResponse>>

    @FormUrlEncoded
    @POST("add_free_time")
    fun addFreeTime(
        @Header("Authorization") authorization: String,
        @Field("day") day: Int,
        @Field("start") startTime: Int,
        @Field("end") endTime: Int,
        @Header("Accept") accept: String = "application/json"
    ): Call<AddTimeResponse>

}