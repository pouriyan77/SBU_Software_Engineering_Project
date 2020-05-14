package ir.sbu.softwareengineering_proposal.ui.completeProfessorProfileFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_complete_professor_profile.*
import kotlinx.android.synthetic.main.fragment_complete_student_profile.*
import kotlinx.android.synthetic.main.loading_button.view.*

/**
 * A simple [Fragment] subclass.
 */
class CompleteProfessorProfile : Fragment(), CompleteProfessorProfileContract.View {

    private lateinit var presenter: CompleteProfessorProfileContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complete_professor_profile, container, false)
    }

    private fun setupOnClicks() {
        completeProfessorProfileBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkCompleteProfessorProfileFields()) {
                //request
            } else {
                showToast("لطفا همه فیلدها را پر کنید")
                showProgressBar(false)
            }
        }
    }

    private fun checkCompleteProfessorProfileFields(): Boolean {
        return true
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulLogin(session: SessionManager) {
        TODO("Not yet implemented")
    }

    override fun showProgressBar(show: Boolean) {
        completeProfessorProfileBtn.button.isEnabled = !show
        if (show){
            completeProfessorProfileBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            completeProfessorProfileBtn.button.text = ""
        }else{
            completeProfessorProfileBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            completeProfessorProfileBtn.button.text = "تکمیل اطلاعات"
    }

}}
