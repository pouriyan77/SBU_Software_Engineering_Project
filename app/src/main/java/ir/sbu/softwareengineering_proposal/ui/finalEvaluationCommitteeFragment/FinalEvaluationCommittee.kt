package ir.sbu.softwareengineering_proposal.ui.finalEvaluationCommitteeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.finalProposalsRecycler.FinalProposalRecyclerInteraction
import ir.sbu.softwareengineering_proposal.adapter.finalProposalsRecycler.FinalProposalsRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.ui.BaseFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_final_evaluation_committee.*

class FinalEvaluationCommittee : BaseFragment(R.layout.fragment_final_evaluation_committee),
    FinalCommitteeContract.View, FinalProposalRecyclerInteraction {

    private lateinit var presenter: FinalCommitteeContract.Presenter
    private lateinit var proposalList: List<Proposal>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FinalEvaluationCommitteePresenterImpl(this)
        presenter.requestAllProposals(
            (requireActivity() as MainActivity).sessionManager?.authToken!!
        )
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

    override fun successfulLoad(proposals: List<Proposal>) {
        proposalList = proposals
        setupRecyclerView(proposals)
    }

    private fun setupRecyclerView(proposals: List<Proposal>) {
        finalEvaluationByAdminRecyclerView.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = FinalProposalsRecyclerAdapter(proposals, this@FinalEvaluationCommittee)
        }
    }

    override fun successfulAcceptOrDecline() {
        showToast("نظر شورا با موفقیت ثبت شد")
    }

    override fun acceptClicked(position: Int) {
        setProposalStatus(proposalList[position].proposalId, "accepted")
    }

    override fun declineClicked(position: Int) {
        setProposalStatus(proposalList[position].proposalId, "decline")
    }

    override fun onItemClickedListener(position: Int) {

    }

    private fun setProposalStatus(proposalId: Int, acceptOrDecline: String) {
        presenter.requestAcceptOrDecline(
            (requireActivity() as MainActivity).sessionManager?.authToken!!,
            proposalId,
            acceptOrDecline
        )
    }

}
