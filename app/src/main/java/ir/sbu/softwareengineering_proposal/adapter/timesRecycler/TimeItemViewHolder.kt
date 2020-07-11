package ir.sbu.softwareengineering_proposal.adapter.timesRecycler

import android.view.View
import androidx.core.content.ContextCompat
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder
import ir.sbu.softwareengineering_proposal.api.responses.TimeResponse
import kotlinx.android.synthetic.main.recycler_available_times_layout.view.*
import java.util.*

class TimeItemViewHolder(itemView: View) :
    RecyclerViewHolder<TimeResponse>(itemView, null) {

    private val timeTextView = itemView.availableTimeTextView
    private val timeStatusImg = itemView.timeStatusImg

    override fun bind(item: TimeResponse) {
        timeTextView.text = String.format(
            itemView.context.getString(
                R.string.timesStr,
                getDay(item.day),
                item.startTime,
                item.endTime
            )
        )

        timeStatusImg.setColorFilter(
            ContextCompat.getColor(
                itemView.context,
                if (item.status.toLowerCase(Locale.getDefault()) == "free")
                    R.color.successColor
                else
                    R.color.errorColor
            )
        )
    }

    private fun getDay(number: Int): String {
        return when (number) {
            1 -> "شنبه"
            2 -> "یکشنبه"
            3 -> "دوشنبه"
            4 -> "سه شنبه"
            5 -> "چهارشنبه"
            6 -> "پنج شنبه"
            else -> "جمعه"
        }
    }
}