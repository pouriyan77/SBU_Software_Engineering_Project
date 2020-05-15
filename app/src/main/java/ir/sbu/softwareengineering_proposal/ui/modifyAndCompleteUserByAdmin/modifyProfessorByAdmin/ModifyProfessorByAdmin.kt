package ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.modifyProfessorByAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.api.requests.ModifyUserByAdminRequest
import ir.sbu.softwareengineering_proposal.api.requests.ProfAndStudentModifyDetails
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment.AcademicDepartmentListFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserContract
import ir.sbu.softwareengineering_proposal.ui.modifyAndCompleteUserByAdmin.ModifyAndCompleteUserPresenterImpl
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_modify_professor_by_admin.*
import kotlinx.android.synthetic.main.loading_button.view.*

class ModifyProfessorByAdmin : Fragment(R.layout.fragment_modify_professor_by_admin),
    ModifyAndCompleteUserContract.View, AcademicDepartmentListFragment.OnSelectDepartmentListener {

    private lateinit var presenter: ModifyAndCompleteUserContract.Presenter
    private lateinit var professor: Professor
    private lateinit var departmentDialog: AcademicDepartmentListFragment
    private var selectedMajor: Major? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ModifyAndCompleteUserPresenterImpl(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        professor = arguments?.getParcelable("PROFESSOR")!!
        departmentDialog = AcademicDepartmentListFragment(this)
        setupViews()
        setUpOnClicks()
    }

    private fun setUpOnClicks() {
        modifyProfByAdminButton.button.setOnClickListener {
            showProgressBar(true)
            val request = ModifyUserByAdminRequest(
                professor.id,
                null,
                null,
                null,
                null,
                null,
                ProfAndStudentModifyDetails(
                    -1, null, null, null, null
                )
            )
            if (checkModifyFields(request)) {
                presenter.requestModify((activity as MainActivity).sessionManager!!.authToken, request)
            } else {
                showProgressBar(false)
            }
        }

        academicDepartmentBtn.setOnClickListener {
            departmentDialog.show(childFragmentManager, null)
        }
    }


    private fun checkModifyFields(request: ModifyUserByAdminRequest): Boolean {
        if (firstNameEditText.text.isNullOrBlank()){
            showToast("نام نمی تواند خالی باشد")
            return false
        }
        request.firstName = firstNameEditText.text.toString().trim()
        if (modifyProfByAdminLastNameTextInput.text.isNullOrBlank()){
            showToast("نام خانوادگی نمی تواند خالی باشد")
            return false
        }
        request.lastName = modifyProfByAdminLastNameTextInput.text.toString().trim()
        if (modifyProfByAdminEmailTextInput.text.isNullOrBlank()){
            showToast("ایمیل نمی تواند خالی باشد")
            return false
        }
        request.email = modifyProfByAdminEmailTextInput.text.toString().trim()
        if (
            !modifyProfByAdminPasswordTextInput.text.isNullOrBlank() ||
            !modifyProfByAdminCPasswordTextInput.text.isNullOrBlank()
        ){
            val password = modifyProfByAdminPasswordTextInput.text.toString().trim()
            val confirmPassword = modifyProfByAdminCPasswordTextInput.text.toString().trim()
            if (password != confirmPassword){
                showToast("رمز عبور و تکرارش یکسان نیستند")
                return false
            }
            request.password = password
            request.confirmPassword = confirmPassword
        }
        if (selectedMajor == null){
            showToast("لطفا گروه آموزشی را مشخص کنید")
            return false
        }
        request.details.majorId = selectedMajor!!.id
        val checkedId = modifyProfByAdminEducationTypeRadio.checkedRadioButtonId
        val checkedRadio = view?.findViewById<RadioButton>(checkedId)
        request.details.profLevel = checkedRadio?.text.toString()
        return true
    }

    private fun setupViews() {
        modifyProfByAdminButton.button.text = "تغییر اطلاعات"
        firstNameEditText.setText(professor.firstName)
        modifyProfByAdminLastNameTextInput.setText(professor.lastName)
        modifyProfByAdminEmailTextInput.setText(professor.email)
        when (professor.degree) {
            professorAssistantRadio.text.toString() -> professorAssistantRadio.isChecked = true
            scienceAssistantRadio.text.toString() -> scienceAssistantRadio.isChecked = true
            fullProfessorRadio.text.toString() -> fullProfessorRadio.isChecked = true
            else -> fullProfessorRadio.isChecked = true
        }
        selectedMajor = professor.major
        if (selectedMajor != null){
            academicDepartmentBtn.text = selectedMajor!!.title
        }
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulModify() {
        findNavController().navigateUp()
    }

    override fun showProgressBar(show: Boolean) {
        modifyProfByAdminButton.button.isEnabled = !show
        if (show){
            modifyProfByAdminButton.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            modifyProfByAdminButton.button.text = ""
        }else{
            modifyProfByAdminButton.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            modifyProfByAdminButton.button.text = "تغییر اطلاعات"
        }
    }

    override fun onSelectDepartment(major: Major) {
        selectedMajor = major
        academicDepartmentBtn.text = major.title
        departmentDialog.dismiss()
    }

}
