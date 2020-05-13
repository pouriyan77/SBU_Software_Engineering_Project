package ir.sbu.softwareengineering_proposal.ui.usersListForAdminFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction

class UsersListForAdmin : Fragment(R.layout.fragment_users_list_for_admin),
    RecyclerViewInteraction {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView() {

    }

    override fun onItemClickedListener(position: Int) {

    }
}
