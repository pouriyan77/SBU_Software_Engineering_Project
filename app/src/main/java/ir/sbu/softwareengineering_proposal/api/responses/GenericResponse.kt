package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

open class GenericResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String
){
    companion object{
        const val FAILED_STATUS = "failed"
        const val SUCCESS_STATUS = "success"
    }
}