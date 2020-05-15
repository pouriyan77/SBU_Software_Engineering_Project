package ir.sbu.softwareengineering_proposal.model

class Proposal(
    val proposalId: Int,
    val persianTitle : String,
    val persianKeywords : String,
    val englishTitle : String,
    val englishKeywords : String,
    val proposalType: String,
    val fieldsOfStudy: List<String> = listOf("یادگیری ماشین", "داده کاوی"),
    val owner: Student,
    val supervisor: Professor?
)