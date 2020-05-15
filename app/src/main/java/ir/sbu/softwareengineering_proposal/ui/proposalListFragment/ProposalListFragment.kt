package ir.sbu.softwareengineering_proposal.ui.proposalListFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.proposalRecycler.ProposalRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
//import ir.sbu.softwareengineering_proposal.utils.fakeProposal
import kotlinx.android.synthetic.main.fragment_proposal_list.*

class ProposalListFragment : Fragment(R.layout.fragment_proposal_list),
    RecyclerViewInteraction, ProposalListContract.View {

    private lateinit var proposalList: List<Proposal>
    private lateinit var presenter: ProposalListContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ProposalListPresenterImpl(this)
        requestProposals()
    }

    private fun requestProposals() {

    }

    private fun setupRecyclerView(proposalList: List<Proposal>) {
        this.proposalList = proposalList
        proposalsRecyclerView?.apply {
            adapter = ProposalRecyclerAdapter(proposalList, this@ProposalListFragment)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {
        val proposal = proposalList[position]
        showToast(proposal.persianTitle)
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulLoad(proposalList: List<Proposal>) {
        setupRecyclerView(proposalList)
    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            (activity as MainActivity).loadingProgressBar.visibility = View.VISIBLE
        } else {
            (activity as MainActivity).loadingProgressBar.visibility = View.GONE
        }
    }
}