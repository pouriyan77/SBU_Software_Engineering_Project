package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class AddTimeResponse(
    @SerializedName("times") val timeList: List<TimeResponse>,
    status: String,
    message: String
) : GenericResponse(status, message)