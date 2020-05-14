package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName
import ir.sbu.softwareengineering_proposal.model.Major

class MajorsResponse(
    @SerializedName("majors") val majorList: List<Major>,
    status: String,
    message: String
) : GenericResponse(status, message)