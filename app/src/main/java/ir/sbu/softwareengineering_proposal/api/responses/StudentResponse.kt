package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.User

class StudentResponse(
    @SerializedName("id") val stdId: Int,
    @SerializedName("student_number") val studentNumber: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("grade") val grade: String?,
    @SerializedName("major") val major: Major?,
    @SerializedName("user") val user: User,
    status: String,
    message: String
) : GenericResponse(status, message){

}