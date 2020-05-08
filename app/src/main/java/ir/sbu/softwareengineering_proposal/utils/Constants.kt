package ir.sbu.softwareengineering_proposal.utils

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.DeskItem

const val BASE_URL = "https://warm-tundra-16580.herokuapp.com/api/"

const val addUserStr = "ثبت نام کاربر جدید"
const val editUserStr = "ویرایش اطلاعات کاربران"

val adminDeskItems = listOf<DeskItem>(
    DeskItem(addUserStr, R.mipmap.add_user_icon),
    DeskItem(editUserStr, R.mipmap.edit_user_icon)
)

//studentDeskItem will be added
//profDeskItem will be added
//png 128 px xhdpi
//تعیین استاد راهنما
//داوری پروپوزال
//آپلود پروپوزال برای دانشجو
