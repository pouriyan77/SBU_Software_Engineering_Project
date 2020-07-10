package ir.sbu.softwareengineering_proposal.ui.proposalListFragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.proposalRecycler.ProposalRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.ui.BaseFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.PROPOSAL_LIST_ADMIN_TYPE
import ir.sbu.softwareengineering_proposal.utils.PROPOSAL_LIST_GROUP_MANAGER_TYPE
import ir.sbu.softwareengineering_proposal.utils.PROPOSAL_LIST_PROFESSOR_TYPE
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
//import ir.sbu.softwareengineering_proposal.utils.fakeProposal
import kotlinx.android.synthetic.main.fragment_proposal_list.*

class ProposalListFragment : BaseFragment(R.layout.fragment_proposal_list),
    RecyclerViewInteraction, ProposalListContract.View {

    private lateinit var proposalList: List<Proposal>
    private lateinit var presenter: ProposalListContract.Presenter
    private var listType = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listType = requireArguments().getInt("LIST_TYPE")
        presenter = ProposalListPresenterImpl(this)
        requestProposals()
    }

    private fun requestProposals() {
        showProgressBar(true)
        val authToken = (activity as MainActivity).sessionManager!!.authToken
        when(listType){
            PROPOSAL_LIST_ADMIN_TYPE -> presenter.requestAllProposals(authToken)
            PROPOSAL_LIST_GROUP_MANAGER_TYPE -> presenter.requestAllProposals(authToken)
            PROPOSAL_LIST_PROFESSOR_TYPE -> presenter.requestAssignedProposals(authToken)
            else -> showProgressBar(false)
        }
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
        val bundle = bundleOf("PROPOSAL" to proposal, "LIST_TYPE" to listType)
        if (listType == PROPOSAL_LIST_PROFESSOR_TYPE){
            findNavController().navigate(
                R.id.action_proposalListFragment_to_examineProposal,
                bundle
            )
        }else {
            findNavController().navigate(
                R.id.action_proposalListFragment_to_professorListFragment,
                bundle
            )
        }
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulLoad(proposalList: List<Proposal>) {
        setupRecyclerView(proposalList)
    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            myActivity.loadingProgressBar.visibility = View.VISIBLE
        } else {
            myActivity.loadingProgressBar.visibility = View.GONE
        }
    }
}