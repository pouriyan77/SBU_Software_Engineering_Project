package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.model.User

class ProfessorResponse(
    @SerializedName("id") val profId: Int,
    @SerializedName("level") val level: String?,
//    @SerializedName("degree") val degree: String,
    @SerializedName("major") val major: Major?,
    @SerializedName("user") val user: User,
    status: String,
    message: String
) : GenericResponse(status, message){

}