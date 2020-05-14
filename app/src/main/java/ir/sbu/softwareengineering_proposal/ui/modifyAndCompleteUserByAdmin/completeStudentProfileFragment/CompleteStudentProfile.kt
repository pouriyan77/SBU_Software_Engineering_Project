package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.completeStudentProfileFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment.AcademicDepartmentListFragment
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserContract
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserPresenterImpl
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_complete_student_profile.*
import kotlinx.android.synthetic.main.loading_button.view.*

class CompleteStudentProfile : Fragment(R.layout.fragment_complete_student_profile),
    ModifyAndCompleteUserContract.View,
    AcademicDepartmentListFragment.OnSelectDepartmentListener {

    private lateinit var presenter: ModifyAndCompleteUserContract.Presenter
    private var selectedMajor: Major? = null
    private lateinit var departmentDialog: AcademicDepartmentListFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ModifyAndCompleteUserPresenterImpl(this)
        departmentDialog = AcademicDepartmentListFragment(this)
        completeStudentProfileBtn.button.text = "تکمیل اطلاعات"
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

    override fun successfulModify() {

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

    override fun onSelectDepartment(major: Major) {
        selectedMajor = major
        academicDepartmentBtn.text = major.title
        departmentDialog.dismiss()
    }
}

