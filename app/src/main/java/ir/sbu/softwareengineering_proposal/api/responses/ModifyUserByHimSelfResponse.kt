package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class ModifyUserByHimSelfResponse(
    @SerializedName("email") val newEmail: String,
    status: String,
    message: String
) : GenericResponse(status, message)