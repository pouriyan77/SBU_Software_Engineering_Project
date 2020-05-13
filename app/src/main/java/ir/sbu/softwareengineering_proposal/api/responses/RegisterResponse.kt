package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class RegisterResponse(
    @SerializedName("user_id") val userId: Int,
    status: String,
    message: String
): GenericResponse(status, message)