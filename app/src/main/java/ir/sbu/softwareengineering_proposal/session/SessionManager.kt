package ir.sbu.softwareengineering_proposal.session

import android.os.Parcel
import android.os.Parcelable
import ir.sbu.softwareengineering_proposal.model.User
import kotlinx.android.parcel.Parcelize

@Parcelize
class SessionManager(val authToken: String, val user: User): Parcelable {
    companion object{
        const val SESSION_MANAGER_CONST_STR = "SESSION"
    }
}