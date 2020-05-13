package ir.sbu.softwareengineering_proposal.ui.chooseUsersToEditFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

import ir.sbu.softwareengineering_proposal.R
import kotlinx.android.synthetic.main.fragment_choose_users_to_edit.*

class ChooseUsersToEditFragment : Fragment(R.layout.fragment_choose_users_to_edit) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        editAllUsersBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_chooseUsersToEditFragment_to_usersListForAdmin2)
        }

        editProfessorsBtn.setOnClickListener {
            val bundle = bundleOf("type" to "professor")
            findNavController().navigate(
                R.id.action_chooseUsersToEditFragment_to_usersListForAdmin2, bundle)
        }

        editStudentsBtn.setOnClickListener {
            val bundle = bundleOf("type" to "student")
            findNavController().navigate(
                R.id.action_chooseUsersToEditFragment_to_usersListForAdmin2, bundle)
        }
    }

}
