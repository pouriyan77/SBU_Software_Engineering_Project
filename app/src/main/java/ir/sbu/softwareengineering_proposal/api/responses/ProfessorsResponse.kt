package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName
import ir.sbu.softwareengineering_proposal.model.Professor

class ProfessorsResponse(
    @SerializedName("professors") val professorList: List<ProfessorResponse>,
    status: String,
    message: String)
    : GenericResponse(status, message)