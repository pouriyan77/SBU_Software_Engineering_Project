package ir.sbu.softwareengineering_proposal.utils

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.DeskItem
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Proposal

const val BASE_URL = "https://warm-tundra-16580.herokuapp.com/api/"

const val addUserStr = "ثبت نام کاربر جدید"
const val editUserStr = "ویرایش اطلاعات کاربران"
const val uploadProposalStr = "آپلود پروپوزال"
const val judgeProposalStr = "داوری پروپوزال"
const val setSupervisorStr = "تعیین استاد راهنما"

val adminDeskItems = listOf<DeskItem>(
    DeskItem(addUserStr, R.mipmap.add_user_icon),
    DeskItem(editUserStr, R.mipmap.edit_user_icon)
)

val studentDeskItems = listOf<DeskItem>(
    DeskItem(uploadProposalStr, R.mipmap.upload_proposal_icon)
)

val professorDeskItem = listOf<DeskItem>(
    DeskItem(judgeProposalStr, R.mipmap.judge_icon),
    DeskItem(setSupervisorStr, R.mipmap.set_supervisor_icon)
)

val fakeProfessors = listOf(
    Professor("دانشکده مهندسی و علوم کامپیوتر", "استادیار", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "علیرضا", "شاملی سندی",
        "", 1),
    Professor("دانشکده مهندسی و علوم کامپیوتر", "استادیار", "گروه آموزشی مهندسی نرم افزار",
        listOf("یادگیری عمیق", "یادگیری ماشین", "پردازش زبان های طبیعی", "بینایی کامپیوتر", "داده کاوی"), "",
        "مهرنوش", "شامس فرد", "", 1),
    Professor("دانشکده مهندسی و علوم کامپیوتر", "استادیار", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "علیرضا", "شاملی سندی",
        "", 1),
    Professor("دانشکده مهندسی و علوم کامپیوتر", "استادیار", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "علیرضا", "شاملی سندی",
        "", 1),
    Professor("دانشکده مهندسی و علوم کامپیوتر", "استادیار", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "علیرضا", "شاملی سندی",
        "", 1)
)

val fakeProposal = listOf(
    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
        "آقایی", "", 1),

    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
        "آقایی", "", 1),

    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
        "آقایی", "", 1),

    Proposal("پیاده سازی سامانه دفاع پروپوزال دانشجویان کارشناسی ارشد", "گروه آموزشی مهندسی نرم افزار",
        listOf("تست نرم افزار", "الگوریتم های پویا"), "", "کیمیا",
        "آقایی", "", 1)

)
