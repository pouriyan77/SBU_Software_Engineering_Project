package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.completeProfessorProfileFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment.AcademicDepartmentListFragment
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserContract
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserPresenterImpl
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_complete_professor_profile.*
import kotlinx.android.synthetic.main.loading_button.view.*

class CompleteProfessorProfile : Fragment(R.layout.fragment_complete_professor_profile),
    ModifyAndCompleteUserContract.View,
    AcademicDepartmentListFragment.OnSelectDepartmentListener {

    private lateinit var presenter: ModifyAndCompleteUserContract.Presenter
    private var selectedMajor: Major? = null
    private lateinit var departmentDialog: AcademicDepartmentListFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter =
            ModifyAndCompleteUserPresenterImpl(this)
        departmentDialog = AcademicDepartmentListFragment(this)
        completeProfessorProfileBtn.button.text = "تکمیل اطلاعات"
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

    override fun successfulModify() {

    }

    override fun showProgressBar(show: Boolean) {
        completeProfessorProfileBtn.button.isEnabled = !show
        if (show) {
            completeProfessorProfileBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            completeProfessorProfileBtn.button.text = ""
        } else {
            completeProfessorProfileBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            completeProfessorProfileBtn.button.text = "تکمیل اطلاعات"
        }
    }

    override fun onSelectDepartment(major: Major) {
        selectedMajor = major
        academicDepartmentBtn.text = major.title
        departmentDialog.dismiss()
    }
}
