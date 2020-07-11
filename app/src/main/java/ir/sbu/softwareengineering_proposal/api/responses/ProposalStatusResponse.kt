package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class ProposalStatusResponse(
    @SerializedName("judge1_message") val judgeMessageBefore1: String?,
    @SerializedName("judge2_message") val judgeMessageBefore2: String?,
    @SerializedName("status") val statusBefore: String?,
    @SerializedName("after_judge1_message") val judgeMessageAfter1: String?,
    @SerializedName("after_judge2_message") val judgeMessageAfter2: String?,
    @SerializedName("after_status") val statusAfter: String?,
    @SerializedName("shora_status") val finalStatus: String?,
    @SerializedName("day") val day: Int?,
    @SerializedName("start") val startTime: Int?,
    @SerializedName("end") val endTime: Int?
)