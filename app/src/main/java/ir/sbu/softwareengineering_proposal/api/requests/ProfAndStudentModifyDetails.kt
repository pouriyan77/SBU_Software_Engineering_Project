package ir.sbu.softwareengineering_proposal.api.requests

import com.google.gson.annotations.SerializedName

class ProfAndStudentModifyDetails(
    @SerializedName("major_id") var majorId: Int,
    @SerializedName("level") var profLevel: String?,
    @SerializedName("student_number") var studentNumber: Int?,
    @SerializedName("grade") var studentGrade: String?,
    @SerializedName("type") var studentStudyType: String?
)