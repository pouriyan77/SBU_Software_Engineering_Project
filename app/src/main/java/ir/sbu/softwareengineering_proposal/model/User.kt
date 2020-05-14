package ir.sbu.softwareengineering_proposal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class User(
    @SerializedName("id") open val id: Int,
    @SerializedName("national_number") open val nationalCode: String,
    @SerializedName("first_name") open val firstName: String,
    @SerializedName("last_name") open val lastName: String,
    @SerializedName("email") open var email: String,
    @SerializedName("role_id") open val roleId: Int,
    open val completeProfileStatus: Boolean
) : Parcelable {

}