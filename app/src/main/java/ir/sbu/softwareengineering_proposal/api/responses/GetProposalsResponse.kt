package ir.sbu.softwareengineering_proposal.api.responses

import com.google.gson.annotations.SerializedName

class GetProposalsResponse(
    @SerializedName("proposals") val proposalList: List<ProposalResponse>,
    status: String,
    message: String
) : GenericResponse(status, message)