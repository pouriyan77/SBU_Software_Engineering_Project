package ir.sbu.softwareengineering_proposal.ui.proposalListFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.proposalRecycler.ProposalRecyclerAdapter
import ir.sbu.softwareengineering_proposal.utils.fakeProposal
import kotlinx.android.synthetic.main.fragment_proposal_list.*

class ProposalListFragment : Fragment(R.layout.fragment_proposal_list), RecyclerViewInteraction {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        proposalsRecyclerView?.apply {
            adapter = ProposalRecyclerAdapter(fakeProposal, this@ProposalListFragment)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {

    }
}