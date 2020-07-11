package ir.sbu.softwareengineering_proposal.ui.availableTimesFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.professorsRecycler.ProfessorsRecyclerAdapter
import ir.sbu.softwareengineering_proposal.adapter.timesRecycler.TimesRecyclerAdapter
import ir.sbu.softwareengineering_proposal.api.responses.TimeResponse
import ir.sbu.softwareengineering_proposal.ui.BaseFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_available_times.*
import kotlinx.android.synthetic.main.loading_button.view.*

class AvailableTimes : BaseFragment(R.layout.fragment_available_times),
    AvailableTimesContract.View {

    private lateinit var presenter: AvailableTimesContract.Presenter
    private var timeRecyclerAdapter: TimesRecyclerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = AvailableTimesPresenterImpl(this)
        showButtonLoading(false)
        presenter.requestTimes(
            (activity as MainActivity).sessionManager?.authToken!!
        )
        setupOnClicks()
    }

    private fun setupOnClicks() {
        addTimeBtn.button.setOnClickListener {
            showButtonLoading(true)
            presenter.requestAddTime(
                (activity as MainActivity).sessionManager?.authToken!!,
                dayTextInput.text.toString().toInt(),
                startTimeTextInput.text.toString().toInt(),
                finishTimeTextInput.text.toString().toInt()
            )
        }
    }

    override fun showToast(message: String) {
        requireContext().longToast(message)
    }

    override fun showFullLoading(show: Boolean) {
        if (show) {
            myActivity.loadingProgressBar.visibility = View.VISIBLE
        } else {
            myActivity.loadingProgressBar.visibility = View.GONE
        }
    }

    override fun showButtonLoading(show: Boolean) {
        addTimeBtn.button.isEnabled = !show
        if (show) {
            addTimeBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            addTimeBtn.button.text = ""
        } else {
            addTimeBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            addTimeBtn.button.text = "افزودن"
        }
    }

    override fun successfulLoad(times: List<TimeResponse>?) {
        setupRecyclerView(times ?: listOf())
    }

    private fun setupRecyclerView(times: List<TimeResponse>) {
        timesRecyclerView.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = TimesRecyclerAdapter(times)

//            if (timeRecyclerAdapter == null) {
//                timeRecyclerAdapter = TimesRecyclerAdapter(times)
//                adapter = timeRecyclerAdapter
//                return
//            }
//            timeRecyclerAdapter?.submitList(times)
        }
    }
}
