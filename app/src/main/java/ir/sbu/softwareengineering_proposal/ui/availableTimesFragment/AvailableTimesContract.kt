package ir.sbu.softwareengineering_proposal.ui.availableTimesFragment

import ir.sbu.softwareengineering_proposal.api.responses.TimeResponse

interface AvailableTimesContract {

    interface View {
        fun showToast(message: String)
        fun showFullLoading(show: Boolean)
        fun showButtonLoading(show: Boolean)
        fun successfulLoad(times: List<TimeResponse>?)
    }

    interface Presenter {
        fun requestTimes(authToken: String)
        fun requestAddTime(authToken: String, day: Int, start: Int, end: Int)
    }
}