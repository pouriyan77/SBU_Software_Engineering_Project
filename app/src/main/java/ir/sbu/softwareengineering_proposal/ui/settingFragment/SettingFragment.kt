package ir.sbu.softwareengineering_proposal.ui.settingFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.User
import ir.sbu.softwareengineering_proposal.ui.loginActivity.LoginActivity
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.adminRoleId
import ir.sbu.softwareengineering_proposal.utils.groupManagerRoleId
import ir.sbu.softwareengineering_proposal.utils.professorRoleId
import ir.sbu.softwareengineering_proposal.utils.studentRoleId
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment(R.layout.fragment_setting) {
    private lateinit var user: User

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = (activity as MainActivity).sessionManager!!.user
        setupViews()
    }

    private fun setupViews() {
        fullNameTextView.text = getString(R.string.fullNameStr, user.firstName, user.lastName)
        roleTextView.text = when(user.roleId){
            studentRoleId -> "دانشجو"
            adminRoleId -> "ادمین"
            professorRoleId -> "استاد"
            groupManagerRoleId -> "مدیر گروه"
            else -> ""
        }

        editProfileBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_modifyUserByHimself)
        }

        exitBtn.setOnClickListener {
            activity?.apply {
                finish()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

}
