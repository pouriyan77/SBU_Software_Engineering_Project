package ir.sbu.softwareengineering_proposal.ui.proposalStatusForStudentFragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.api.responses.ProposalStatusResponse
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.ui.BaseFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_proposal_status.*
import kotlinx.android.synthetic.main.fragment_proposal_status.uploadProposalBtn
import kotlinx.android.synthetic.main.fragment_upload_proposal.*
import java.util.*

class ProposalStatus : BaseFragment(R.layout.fragment_proposal_status), ProposalStatusContract.View {

    private lateinit var presenter: ProposalStatusContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ProposalStatusPresenterImpl(this)
        presenter.requestProposalStatus(
            (requireActivity() as MainActivity).sessionManager?.authToken!!,
            (requireActivity() as MainActivity).sessionManager?.user!!.id
        )
        setupOnClicks()
    }

    private fun setupOnClicks() {
        uploadProposalBtn.setOnClickListener {
            val intent = Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_GET_CONTENT)

            startActivityForResult(
                Intent.createChooser(intent, "Select a file"),
                1234
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val splittedData = data?.dataString?.split("/")
        val fileName = splittedData?.get(splittedData.size - 1)
        proposalFileNameAgain.text = fileName
        showProgressBar(true)
        Handler().postDelayed({
            showProgressBar(false)
            showToast("پروپوزال مجددا آپلود شد")
            finalDecisionBeforePresentation.text = "مشخص نشده"
        }, 2000)
    }

    override fun showToast(message: String) {
        requireContext().longToast(message)
    }

    private fun getStatus(status: String?) : String {
        return when(status?.toLowerCase(Locale.getDefault())) {
            "accepted" -> "تایید"
            "declined" -> "رد"
            "waiting" -> "اصلاح"
            else -> "مشخص نشده"
        }
    }

    override fun successfulLoad(proposalStatus: ProposalStatusResponse) {
        val beforeStatus = getStatus(proposalStatus.statusBefore)
        val afterStatus = getStatus(proposalStatus.statusAfter)
        val finalStatus = getStatus(proposalStatus.finalStatus)
        judgeNumber1CommentBeforePresentation.text = proposalStatus.judgeMessageBefore1 ?: "مشخص نشده"
        judgeNumber2CommentBeforePresentation.text = proposalStatus.judgeMessageBefore2 ?: "مشخص نشده"
        finalDecisionBeforePresentation.text = beforeStatus
        judgeNumber1CommentAfterPresentation.text = proposalStatus.judgeMessageAfter1 ?: "مشخص نشده"
        judgeNumber2CommentAfterPresentation.text = proposalStatus.judgeMessageAfter2 ?: "مشخص نشده"
        finalDecisionAfterPresentation.text = afterStatus
        committeeStatus.text = finalStatus
        presentationTime.text = proposalStatus.day?.let {
            String.format(
                getString(
                    R.string.timesStr,
                    getDay(it),
                    proposalStatus.startTime,
                    proposalStatus.endTime
                )
            )
        } ?: "مشخص نشده"
    }

    private fun getDay(number: Int) : String {
        return when(number) {
            1 -> "شنبه"
            2 -> "یکشنبه"
            3 -> "دوشنبه"
            4 -> "سه شنبه"
            5 -> "چهارشنبه"
            6 -> "پنج شنبه"
            else -> "جمعه"
        }
    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            myActivity.loadingProgressBar.visibility = View.VISIBLE
        }else{
            myActivity.loadingProgressBar.visibility = View.GONE
        }
    }

}