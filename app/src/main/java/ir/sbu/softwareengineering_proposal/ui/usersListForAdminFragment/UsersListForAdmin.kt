package ir.sbu.softwareengineering_proposal.ui.usersListForAdminFragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.usersRecycler.UsersRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Student
import ir.sbu.softwareengineering_proposal.model.User
import ir.sbu.softwareengineering_proposal.ui.BaseFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_users_list_for_admin.*

class UsersListForAdmin : BaseFragment(R.layout.fragment_users_list_for_admin),
    RecyclerViewInteraction, UserListForAdminContract.View {

    private lateinit var presenter: UserListForAdminPresenterImpl
    private lateinit var userList: List<User>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = UserListForAdminPresenterImpl(this)
        if (savedInstanceState == null) {
            requestToServer()
        }
    }

    private fun requestToServer() {
        showProgressBar(true)
        presenter.getUsersFromServer(
            myActivity.sessionManager!!.authToken,
            arguments?.getString("type")
        )
    }


    private fun setupRecyclerView(users: List<User>) {
        getUserRecyclerView?.apply {
            adapter = UsersRecyclerAdapter(users, this@UsersListForAdmin)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {
        val user = userList[position]
        if (user is Student){
            val bundle = bundleOf("STUDENT" to user)
            findNavController().navigate(
                R.id.action_usersListForAdmin2_to_modifyStudentByAdmin, bundle)
        }else if (user is Professor){
            val bundle = bundleOf("PROFESSOR" to user)
            findNavController().navigate(
                R.id.action_usersListForAdmin2_to_modifyProfessorByAdmin, bundle)
        }
    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            myActivity.loadingProgressBar.visibility = View.VISIBLE
        }else{
            myActivity.loadingProgressBar.visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulLoad(userList: List<User>) {
        this.userList = userList
        setupRecyclerView(userList)
    }

}
