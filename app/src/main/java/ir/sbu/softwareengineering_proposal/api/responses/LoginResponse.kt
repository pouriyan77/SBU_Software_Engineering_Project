package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName
import ir.sbu.softwareengineering_proposal.model.User

class LoginResponse(
    @SerializedName("auth_token") val authToken: String,
    @SerializedName("role_id") val roleId: String,
    @SerializedName("user_information") val user: User,
    status: String,
    message: String
): GenericResponse(status, message)