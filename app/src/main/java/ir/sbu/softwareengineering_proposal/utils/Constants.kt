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
const val availableTimesForProfessorsStr = "زمان های خالی برای تعیین تایم دفاع"

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
    DeskItem(setJudgeStr, R.mipmap.judge_icon)
)

val professorDeskItems = listOf<DeskItem>(
    DeskItem(judgeProposalStr, R.mipmap.judge_icon),
    DeskItem(availableTimesForProfessorsStr, R.mipmap.available_times_icon)
)

//val fakeProfessors = listOf(
//    Professor(1, "استادیار", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), 1,"", "علیرضا", "شاملی سندی",
//        "", 1),
//    Professor(2, "استادیار", "گروه آموزشی مهندسی نرم افزار",
//        listOf("یادگیری عمیق", "یادگیری ماشین", "پردازش زبان های طبیعی", "بینایی کامپیوتر", "داده کاوی"), 2, "",
//        "مهرنوش", "شامس فرد", "", 1),
//    Professor(3, "استادیار", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), 3, "", "علیرضا", "شاملی سندی",
//        "", 1),
//    Professor(4, "استادیار", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), 4, "", "علیرضا", "شاملی سندی",
//        "", 1),
//    Professor(5, "استادیار", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), 5, "", "علیرضا", "شاملی سندی",
//        "", 1)
//)

//val fakeProposal = listOf(
//    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
//        "آقایی", "", 1),
//
//    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
//        "آقایی", "", 1),
//
//    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
//        "آقایی", "", 1),
//
//    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
//        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
//        "آقایی", "", 1)
//
//)

//val fakeUsers = listOf(
//    User(1, "", "کیمیا", "آقایی", "", 1),
//    User(2, "", "علیرضا", "شاملی", "", 1),
//    User(3, "", "کیمیا", "آقایی", "", 1)
//)

val fakeAcademicList = listOf<Major>(
    Major(1, "مهندسی نرم افزار و سیستم های اطلاعاتی"),
    Major(2, "هوش مصنوعی و سیستم های خبره"),
    Major(3, "معماری کامپیوتر"),
    Major(4, "امنیت شبکه"),
    Major(5, "الگوریتم")
)

