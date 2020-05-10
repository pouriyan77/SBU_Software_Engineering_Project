package ir.sbu.softwareengineering_proposal.model

class Professor(
    val faculty: String, val degree: String, val group: String, val fieldsOfStudy: List<String>,
    nationalCode: String, firstName: String, lastName: String, email: String, roleId: Int
): User(nationalCode, firstName, lastName, email, roleId)