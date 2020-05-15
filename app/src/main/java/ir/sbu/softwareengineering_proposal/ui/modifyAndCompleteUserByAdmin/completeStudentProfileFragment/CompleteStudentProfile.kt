package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.completeStudentProfileFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.api.requests.ModifyUserByAdminRequest
import ir.sbu.softwareengineering_proposal.api.requests.ProfAndStudentModifyDetails
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment.AcademicDepartmentListFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
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
    private var userId: Int = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ModifyAndCompleteUserPresenterImpl(this)
        userId = requireArguments().getInt("USER_ID")
        departmentDialog = AcademicDepartmentListFragment(this)
        setupOnClicks()
    }

    private fun setupOnClicks() {
        completeStudentProfileBtn.button.text = "تکمیل اطلاعات"
        completeStudentProfileBtn.button.setOnClickListener {
            showProgressBar(true)
            val request = ModifyUserByAdminRequest(
                userId,
                null,
                null,
                null,
                null,
                null,
                ProfAndStudentModifyDetails(
                    -1, null, null, null, null
                )
            )
            if (checkCompleteStudentProfileFields(request)) {
                presenter.requestModify((activity as MainActivity).sessionManager!!.authToken, request)
            } else {
                showProgressBar(false)
            }
        }

        academicDepartmentBtn.setOnClickListener {
            departmentDialog.show(childFragmentManager, null)
        }
    }

    private fun checkCompleteStudentProfileFields(request: ModifyUserByAdminRequest): Boolean {
        if (selectedMajor == null) {
            showToast("لطفا گروه آموزشی را مشخص کنید")
            return false
        }
        request.details.majorId = selectedMajor!!.id
        if (!completeStudentProfileStudentNumberTextInput.text.isNullOrBlank()){
            if (completeStudentProfileStudentNumberTextInput.text.toString().length != 8){
                showToast("شماره دانشجویی باید هشت رقم باشد")
                return false
            }
            request.details.studentNumber =
                completeStudentProfileStudentNumberTextInput.text.toString().toInt()
        }
        if (selectedMajor == null){
            showToast("لطفا گروه آموزشی را مشخص کنید")
            return false
        }
        request.details.majorId = selectedMajor!!.id

        // to do type and grade and enter year
        return true
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulModify() {
        showToast("اظلاعات دانشجو با موفقیت تکمیل شد")
        findNavController().navigate(R.id.action_completeStudentProfile_to_registerFragment)
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

