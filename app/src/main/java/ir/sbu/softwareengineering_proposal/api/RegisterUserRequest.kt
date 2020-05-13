package ir.sbu.softwareengineering_proposal.api

import com.google.gson.annotations.SerializedName

class RegisterUserRequest(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("national_number") val nationalCode: String,
    @SerializedName("password") val password: String,
    @SerializedName("c_password") val confirmPassword: String,
    @SerializedName("role_id") val roleId: Int
) {
}