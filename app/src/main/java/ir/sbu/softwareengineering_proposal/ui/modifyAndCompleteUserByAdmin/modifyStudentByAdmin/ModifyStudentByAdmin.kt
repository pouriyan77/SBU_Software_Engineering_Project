package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.modifyStudentByAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.model.Student
import ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment.AcademicDepartmentListFragment
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserContract
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserPresenterImpl
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_modify_student_by_admin.*
import kotlinx.android.synthetic.main.loading_button.view.*

class ModifyStudentByAdmin : Fragment(R.layout.fragment_modify_student_by_admin),
    ModifyAndCompleteUserContract.View, AcademicDepartmentListFragment.OnSelectDepartmentListener {

    private lateinit var student: Student
    private lateinit var presenter: ModifyAndCompleteUserContract.Presenter
    private lateinit var departmentDialog: AcademicDepartmentListFragment
    private var selectedMajor: Major? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ModifyAndCompleteUserPresenterImpl(this)
        student = arguments?.getParcelable("STUDENT")!!
        departmentDialog = AcademicDepartmentListFragment(this)
        setupViews()
        setupOnCLicks()
    }

    private fun setupViews() {
        modifyStudentByAdminBtn.button.text = "تغییر اطلاعات"
        firstNameEditText.setText(student.firstName)
        modifyStudentByAdminLastNameTextInput.setText(student.lastName)
        modifyStudentByAdminEmailTextInput.setText(student.email)
        modifyStudentByAdminStudentNumberTextInput.setText(student.studentNumber)
        modifyStudentByAdminEntranceYearTextInput.setText("1395")
    }

    private fun checkModifyStudentFields(): Boolean {
        return true
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

        academicDepartmentBtn.setOnClickListener {
            departmentDialog.show(childFragmentManager, null)
        }
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulModify() {

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
            modifyStudentByAdminBtn.button.text = "تغییر اطلاعات"
        }
    }

    override fun onSelectDepartment(major: Major) {
        selectedMajor = major
        academicDepartmentBtn.text = major.title
        departmentDialog.dismiss()
    }

}
