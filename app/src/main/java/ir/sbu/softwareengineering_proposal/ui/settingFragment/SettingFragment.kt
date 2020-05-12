package ir.sbu.softwareengineering_proposal.ui.settingFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.User
import ir.sbu.softwareengineering_proposal.ui.loginActivity.LoginActivity
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
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
        exitBtn.setOnClickListener {
            activity?.apply {
                finish()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

}
