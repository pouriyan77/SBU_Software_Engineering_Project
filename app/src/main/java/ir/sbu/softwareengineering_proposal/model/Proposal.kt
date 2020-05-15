package ir.sbu.softwareengineering_proposal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Proposal(
    val proposalId: Int,
    val persianTitle : String,
    val persianKeywords : String,
    val englishTitle : String,
    val englishKeywords : String,
    val proposalType: String,
    val fieldsOfStudy: List<String> = listOf("یادگیری ماشین", "داده کاوی"),
    val owner: Student,
    var supervisor: Professor?
) : Parcelable