package ir.sbu.softwareengineering_proposal.utils

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.DeskItem
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.model.User

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


val adminDeskItems = listOf<DeskItem>(
    DeskItem(addUserStr, R.mipmap.add_user_icon),
    DeskItem(editUserStr, R.mipmap.edit_user_icon),
            DeskItem(setSupervisorStr, R.mipmap.set_supervisor_icon)
)

val studentDeskItems = listOf<DeskItem>(
    DeskItem(uploadProposalStr, R.mipmap.upload_proposal_icon)
)

val professorDeskItem = listOf<DeskItem>(
    DeskItem(judgeProposalStr, R.mipmap.judge_icon),
    DeskItem(setJudgeStr, R.mipmap.judge_icon)
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

