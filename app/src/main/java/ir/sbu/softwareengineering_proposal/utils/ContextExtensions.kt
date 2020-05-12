package ir.sbu.softwareengineering_proposal.utils

import android.content.Context
import android.graphics.Typeface
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

fun Context.shortToast(message: CharSequence)
{
    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    setToastTypeFace(toast)
    toast.show()
}

fun Context.longToast(message: CharSequence)
{
    val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
    setToastTypeFace(toast)
    toast.show()
}

private fun setToastTypeFace(toast: Toast)
{
    val toastText = (toast.view as LinearLayout).getChildAt(0) as TextView
    toastText.typeface = Typeface.createFromAsset(toast.view.context.assets,
        "fonts/iran_sans_1.ttf")
}