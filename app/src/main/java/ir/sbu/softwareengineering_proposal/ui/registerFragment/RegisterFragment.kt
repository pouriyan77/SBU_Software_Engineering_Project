package ir.sbu.softwareengineering_proposal.ui.registerFragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.api.requests.RegisterUserRequest
import ir.sbu.softwareengineering_proposal.utils.groupManagerRoleId
import ir.sbu.softwareengineering_proposal.utils.longToast
import ir.sbu.softwareengineering_proposal.utils.professorRoleId
import ir.sbu.softwareengineering_proposal.utils.studentRoleId
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.loading_button.view.*

class RegisterFragment : Fragment(R.layout.fragment_register), RegisterContract.View {

    private lateinit var presenter: RegisterContract.Presenter
    private var isStudent: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = RegisterPresenterImpl(this)
        setupViews()
    }

    private fun setupViews() {
        registerBtn.button.text = "ثبت نام"

        registerBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkRegisterFields()) {
                if (checkRepeatPassword()){
                    if (registerNationalNumber.text.toString().length == 10){
                        isStudent = false
                        val roleId = when(registerRadioGroup.checkedRadioButtonId){
                            profRadio.id -> professorRoleId
                            departmentManagerRadio.id -> groupManagerRoleId
                            studentRadio.id -> {
                                isStudent = true
                                studentRoleId
                            }
                            else -> professorRoleId
                        }
                        presenter.requestRegister(
                            RegisterUserRequest(
                                registerName.text.toString().trim(),
                                registerLastName.text.toString().trim(),
                                registerEmail.text.toString().trim(),
                                registerNationalNumber.text.toString().trim(),
                                registerPassword.text.toString().trim(),
                                registerRepeatPassword.text.toString().trim(),
                                roleId
                            )
                        )
                    }else{
                        showToast("کد ملی باید ده رقم باشد")
                        showProgressBar(false)
                    }
                }else{
                    showToast("رمز عبور و تکرارش یکسان نیستند")
                    showProgressBar(false)
                }
            }
            else {
                showToast("لطفا همه فیلدها را پر کنید")
                showProgressBar(false)
            }
        }
    }

    private fun checkRegisterFields(): Boolean {
        return !registerName.text.isNullOrBlank() &&
                !registerEmail.text.isNullOrBlank() &&
                !registerLastName.text.isNullOrBlank() &&
                !registerNationalNumber.text.isNullOrBlank() &&
                !registerPassword.text.isNullOrBlank() &&
                !registerRepeatPassword.text.isNullOrBlank()
    }

    private fun checkRepeatPassword() =
        (registerPassword.text.toString().trim() == registerRepeatPassword.text.toString().trim())

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulRegister(userId: Int) {
        showToast("کاربر با موفقیت ثبت شد")
        val bundle = bundleOf("USER_ID" to userId)
        if (isStudent){
            findNavController().navigate(
                R.id.action_registerFragment_to_completeStudentProfile, bundle)
        }else{
            findNavController().navigate(
                R.id.action_registerFragment_to_completeProfessorProfile, bundle)
        }
    }

    override fun showProgressBar(show: Boolean) {
        registerBtn.button.isEnabled = !show
        if (show){
            registerBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            registerBtn.button.text = ""
        }else{
            registerBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            registerBtn.button.text = "ثبت نام"
        }
    }
}