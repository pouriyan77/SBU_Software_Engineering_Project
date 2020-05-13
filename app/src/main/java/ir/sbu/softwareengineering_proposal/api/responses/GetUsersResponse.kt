package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class GetUsersResponse(
    @SerializedName("professors") val professorList: List<ProfessorResponse>?,
    @SerializedName("students") val studentList: List<StudentResponse>?,
    status: String,
    message: String
): GenericResponse(status, message) {
}