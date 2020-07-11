package ir.sbu.softwareengineering_proposal.utils

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.*

const val BASE_URL = "https://warm-tundra-16580.herokuapp.com/api/"
const val PRE_TOKEN = "Bearer "

const val adminRoleId = 1
const val studentRoleId = 2
const val groupManagerRoleId = 3
const val professorRoleId = 4

const val addUserStr = "ثبت نام کاربر جدید"
const val editUserStr = "ویرایش اطلاعات کاربران"
const val uploadProposalStr = "آپلود پروپوزال"
const val judgeProposalStr = "داوری پروپوزال"
const val setSupervisorStr = "تعیین استاد راهنما"
const val setJudgeStr = "مشخص کردن داور"
const val finalEvaluationStr = "وضعیت پروپوزال"
const val committeeEvaluationStr = "نظر نهایی شورا"
const val availableTimesForProfessorsStr = "زمان های خالی"

const val PROPOSAL_LIST_ADMIN_TYPE = 1
const val PROPOSAL_LIST_PROFESSOR_TYPE = 2
const val PROPOSAL_LIST_GROUP_MANAGER_TYPE = 3

const val STUDENT_BA_GRADE = ""
const val STUDENT_MA_GRADE = ""
const val STUDENT_PHD_GRADE = ""

const val STUDENT_ROOZANE_STUDY_TYPE = "roozane"
const val STUDENT_SHABANE_STUDY_TYPE = "shabane"
const val STUDENT_PARDIS_STUDY_TYPE = "pardis"


val adminDeskItems = listOf<DeskItem>(
    DeskItem(addUserStr, R.mipmap.add_user_icon),
    DeskItem(editUserStr, R.mipmap.edit_user_icon),
    DeskItem(setSupervisorStr, R.mipmap.set_supervisor_icon),
    DeskItem(committeeEvaluationStr, R.mipmap.committee_evaluation_icon)
)

val studentDeskItems = listOf<DeskItem>(
    DeskItem(uploadProposalStr, R.mipmap.upload_proposal_icon),
    DeskItem(finalEvaluationStr, R.mipmap.final_evaluation_icon)
)

val groupManagerDeskItems = listOf<DeskItem>(
    DeskItem(judgeProposalStr, R.mipmap.judge_icon),
    DeskItem(setJudgeStr, R.mipmap.judge_icon),
    DeskItem(availableTimesForProfessorsStr, R.mipmap.available_times_icon)
)

val professorDeskItems = listOf<DeskItem>(
    DeskItem(judgeProposalStr, R.mipmap.judge_icon),
    DeskItem(availableTimesForProfessorsStr, R.mipmap.available_times_icon)
)

