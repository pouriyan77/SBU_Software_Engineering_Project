package ir.sbu.softwareengineering_proposal.ui.completeStudentProfileFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_complete_student_profile.*
import kotlinx.android.synthetic.main.loading_button.view.*

class CompleteStudentProfile : CompleteStudentProfileContract.View,
    Fragment(R.layout.fragment_complete_student_profile) {

    private lateinit var presenter: CompleteStudentProfileContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CompleteStudentProfilePresenterImpl(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupOnClicks() {
        completeStudentProfileBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkCompleteStudentProfileFields()) {
                //request
            } else {
                showToast("لطفا همه فیلد ها را پر کنید")
                showProgressBar(false)
            }
        }
    }

    private fun checkCompleteStudentProfileFields(): Boolean {
        return true
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulLogin(session: SessionManager) {
        TODO("Not yet implemented")
    }

    override fun showProgressBar(show: Boolean) {
        completeStudentProfileBtn.button.isEnabled = !show
        if (show) {
            completeStudentProfileBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            completeStudentProfileBtn.button.text = ""
        } else {
            completeStudentProfileBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            completeStudentProfileBtn.button.text = "تکمیل اطلاعات"
        }

    }
}

