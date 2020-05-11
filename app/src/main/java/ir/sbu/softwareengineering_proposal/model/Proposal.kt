package ir.sbu.softwareengineering_proposal.model

class Proposal(
    val title : String, val group: String, val fieldsOfStudy: List<String>,
    nationalCode: String, firstName: String, lastName: String, email: String, roleId: Int
) : User(nationalCode, firstName, lastName, email, roleId)