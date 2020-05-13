package ir.sbu.softwareengineering_proposal.model

class Proposal(
    val title : String,
    val group: String,
    val fieldsOfStudy: List<String>,
    val owner: Student
)