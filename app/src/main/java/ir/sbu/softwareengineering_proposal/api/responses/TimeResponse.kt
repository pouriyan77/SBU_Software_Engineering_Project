package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class TimeResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("day") val day: Int,
    @SerializedName("start") val startTime: Int,
    @SerializedName("end") val endTime: Int,
    @SerializedName("status") val status: String
)