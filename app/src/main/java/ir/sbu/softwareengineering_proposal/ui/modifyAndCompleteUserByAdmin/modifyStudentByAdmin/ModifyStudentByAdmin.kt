package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.modifyStudentByAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.api.requests.ModifyUserByAdminRequest
import ir.sbu.softwareengineering_proposal.api.requests.ProfAndStudentModifyDetails
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.model.Student
import ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment.AcademicDepartmentListFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserContract
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserPresenterImpl
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_modify_professor_by_admin.*
import kotlinx.android.synthetic.main.fragment_modify_student_by_admin.*
import kotlinx.android.synthetic.main.fragment_modify_student_by_admin.academicDepartmentBtn
import kotlinx.android.synthetic.main.fragment_modify_student_by_admin.firstNameEditText
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

        // to do
        modifyStudentByAdminEntranceYearTextInput.setText("1395")

        when (student.type) {
            // to do
        }
        when (student.grade) {
            // to do
        }
        selectedMajor = student.major
        if (selectedMajor != null){
            academicDepartmentBtn.text = selectedMajor!!.title
        }
    }

    private fun setupOnCLicks() {
        modifyStudentByAdminBtn.button.setOnClickListener {
            showProgressBar(true)
            val request = ModifyUserByAdminRequest(
                student.id,
                null,
                null,
                null,
                null,
                null,
                ProfAndStudentModifyDetails(
                    -1, null, null, null, null
                )
            )
            if (checkModifyStudentFields(request)) {
                presenter.requestModify((activity as MainActivity).sessionManager!!.authToken, request)
            } else {
                showProgressBar(false)
            }
        }

        academicDepartmentBtn.setOnClickListener {
            departmentDialog.show(childFragmentManager, null)
        }
    }

    private fun checkModifyStudentFields(request: ModifyUserByAdminRequest): Boolean {
        if (firstNameEditText.text.isNullOrBlank()){
            showToast("نام نمی تواند خالی باشد")
            return false
        }
        request.firstName = firstNameEditText.text.toString().trim()
        if (modifyStudentByAdminLastNameTextInput.text.isNullOrBlank()){
            showToast("نام خانوادگی نمی تواند خالی باشد")
            return false
        }
        request.lastName = modifyStudentByAdminLastNameTextInput.text.toString().trim()
        if (modifyStudentByAdminEmailTextInput.text.isNullOrBlank()){
            showToast("ایمیل نمی تواند خالی باشد")
            return false
        }
        request.email = modifyStudentByAdminEmailTextInput.text.toString().trim()
        if (
            !modifyStudentByAdminPasswordTextInput.text.isNullOrBlank() ||
            !modifyStudentByAdminCPasswordTextInput.text.isNullOrBlank()
        ){
            val password = modifyStudentByAdminPasswordTextInput.text.toString().trim()
            val confirmPassword = modifyStudentByAdminCPasswordTextInput.text.toString().trim()
            if (password != confirmPassword){
                showToast("رمز عبور و تکرارش یکسان نیستند")
                return false
            }
            request.password = password
            request.confirmPassword = confirmPassword
        }
        if (!modifyStudentByAdminStudentNumberTextInput.text.isNullOrBlank()){
            if (modifyStudentByAdminStudentNumberTextInput.text.toString().length != 8){
                showToast("شماره دانشجویی باید هشت رقم باشد")
                return false
            }
            request.details.studentNumber =
                modifyStudentByAdminStudentNumberTextInput.text.toString().toInt()
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
        findNavController().navigateUp()
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
