package ir.sbu.softwareengineering_proposal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Major(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String
) : Parcelable {
}