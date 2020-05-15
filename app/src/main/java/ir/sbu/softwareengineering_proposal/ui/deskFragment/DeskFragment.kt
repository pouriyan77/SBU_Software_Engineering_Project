package ir.sbu.softwareengineering_proposal.ui.deskFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.deskRecycler.DeskRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.DeskItem
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.model.User
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.*
import kotlinx.android.synthetic.main.fragment_desk.*

class DeskFragment : Fragment(R.layout.fragment_desk), RecyclerViewInteraction {

    private lateinit var user: User
    private lateinit var deskItems: List<DeskItem>

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        user = (activity as MainActivity).sessionManager!!.user
        setupDeskItems()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        deskRecyclerView?.apply {
            adapter = DeskRecyclerAdapter(deskItems, this@DeskFragment)
            layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                MarginSpacingItemDecoration(
                    16
                )
            )
        }


    }

    private fun setupDeskItems() {
        deskItems = when(user.roleId){
            adminRoleId -> adminDeskItems
            studentRoleId -> studentDeskItems
            groupManagerRoleId -> professorDeskItem
            professorRoleId -> professorDeskItem
            else -> adminDeskItems
        }
    }

    override fun onItemClickedListener(position: Int) {
        val name = deskItems[position].name

        when(name) {

            addUserStr -> findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
            editUserStr -> findNavController().navigate(R.id.action_mainFragment_to_chooseUsersToEditFragment)
            setSupervisorStr -> {
                val bundle = bundleOf("LIST_TYPE" to PROPOSAL_LIST_ADMIN_TYPE)
                findNavController().navigate(R.id.action_mainFragment_to_proposalListFragment, bundle)
            }
            setJudgeStr -> {
                val bundle = bundleOf("LIST_TYPE" to PROPOSAL_LIST_GROUP_MANAGER_TYPE)
                findNavController().navigate(R.id.action_mainFragment_to_proposalListFragment, bundle)
            }
            judgeProposalStr -> {
                val bundle = bundleOf("LIST_TYPE" to PROPOSAL_LIST_PROFESSOR_TYPE)
                findNavController().navigate(R.id.action_mainFragment_to_proposalListFragment, bundle)
            }
            uploadProposalStr -> findNavController().navigate(R.id.action_mainFragment_to_uploadProposal)
            else -> Toast.makeText(context, name, Toast.LENGTH_LONG).show()
        }
    }
}