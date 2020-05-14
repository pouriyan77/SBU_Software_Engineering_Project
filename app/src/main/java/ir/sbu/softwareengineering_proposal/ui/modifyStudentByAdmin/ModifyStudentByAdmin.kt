package ir.sbu.softwareengineering_proposal.ui.modifyStudentByAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Student
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_modify_student_by_admin.*
import kotlinx.android.synthetic.main.loading_button.view.*

class ModifyStudentByAdmin : Fragment(R.layout.fragment_modify_student_by_admin),
    ModifyStudentByAdminContract.View {

    private lateinit var student: Student
    private lateinit var presenter: ModifyStudentByAdminContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        presenter = ModifyStudentByAdminPresenterImpl(this)
        //setupOnClicks()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        student = arguments?.getParcelable("STUDENT")!!
        setupViews()
    }

    private fun setupViews() {
        firstNameEditText.setText(student.firstName)
        modifyStudentByAdminLastNameTextInput.setText(student.lastName)
        modifyStudentByAdminEmailTextInput.setText(student.email)
        modifyStudentByAdminStudentNumberTextInput.setText(student.studentNumber)
        modifyStudentByAdminEntranceYearTextInput.setText("1395")
    }

    private fun checkModifyStudentFields(): Boolean {
        return true;
    }

    private fun setupOnCLicks() {
        modifyStudentByAdminBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkModifyStudentFields()) {
                //request
            } else {
                showToast("همه فیلد ها را پر کنی")
                showProgressBar(false)
            }
        }
    }

    override fun showToast(message: String) {
        TODO("Not yet implemented")
        context?.longToast(message)
    }

    override fun successfulModify(session: SessionManager) {
        TODO("Not yet implemented")
    }

    override fun showProgressBar(show: Boolean) {
        modifyStudentByAdminBtn.button.isEnabled = !show
        if (show){
            modifyStudentByAdminBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            modifyStudentByAdminBtn.button.text = ""
        }else{
            modifyStudentByAdminBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            modifyStudentByAdminBtn.button.text = "ورود"
        }
    }

}
