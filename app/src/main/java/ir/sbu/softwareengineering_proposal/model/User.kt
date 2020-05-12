package ir.sbu.softwareengineering_proposal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class User(
    @SerializedName("national_number") val nationalCode: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("role_id") val roleId: Int) : Parcelable {

}