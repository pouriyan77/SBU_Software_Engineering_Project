package ir.sbu.softwareengineering_proposal.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Professor(
    val profId: Int,
    val degree: String?,
    val major: Major?,
    val fieldsOfStudy: List<String>,
    override val id: Int,
    override val nationalCode: String,
    override val firstName: String,
    override val lastName: String,
    override var email: String,
    override val roleId: Int,
    override val completeProfileStatus: Boolean,
    var selected: Boolean = false
): User(id, nationalCode, firstName, lastName, email, roleId, completeProfileStatus)