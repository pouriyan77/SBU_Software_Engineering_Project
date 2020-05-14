package ir.sbu.softwareengineering_proposal.api.requests

import com.google.gson.annotations.SerializedName
import ir.sbu.softwareengineering_proposal.api.responses.GenericResponse

class ModifyUserByAdminRequest(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("first_name") var firstName: String?,
    @SerializedName("last_name") var lastName: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("password") var password: String?,
    @SerializedName("c_password") var confirmPassword: String?,
    @SerializedName("detail") val details: ProfAndStudentModifyDetails
)