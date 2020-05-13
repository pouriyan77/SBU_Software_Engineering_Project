package ir.sbu.softwareengineering_proposal.ui.usersListForAdminFragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.usersRecycler.UsersRecyclerAdapter
import ir.sbu.softwareengineering_proposal.utils.fakeUsers
import kotlinx.android.synthetic.main.fragment_users_list_for_admin.*

class UsersListForAdmin : androidx.fragment.app.Fragment(R.layout.fragment_users_list_for_admin),
    RecyclerViewInteraction {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        getUserRecyclerView?.apply {
            adapter = UsersRecyclerAdapter(fakeUsers, this@UsersListForAdmin)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {

    }
}
