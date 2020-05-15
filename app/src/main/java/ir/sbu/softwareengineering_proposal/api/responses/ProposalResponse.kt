package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class ProposalResponse(
    @SerializedName("id") val proposalId: Int,
    @SerializedName("persian_title") val persianTitle: String,
    @SerializedName("persian_keywords") val persianKeyword: String,
    @SerializedName("english_title") val englishTitle: String,
    @SerializedName("english_keywords") val englishKeyWords: String,
    @SerializedName("type") val proposalType: String,
    @SerializedName("filename") val fileName: String,
    @SerializedName("student") val student: StudentResponse,
    @SerializedName("professor") val supervisor: ProfessorResponse?,
    status: String,
    message: String
) : GenericResponse(status, message)