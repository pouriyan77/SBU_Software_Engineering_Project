package ir.sbu.softwareengineering_proposal.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Student(
    val stdId: Int,
    val studentNumber: String?,
    val type: String?,
    val grade: String?,
    val major: Major?,
    override val id: Int,
    override val nationalCode: String,
    override val firstName: String,
    override val lastName: String,
    override var email: String,
    override val roleId: Int,
    override val completeProfileStatus: Boolean
): User(id, nationalCode, firstName, lastName, email, roleId, completeProfileStatus)