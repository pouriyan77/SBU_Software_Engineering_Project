package ir.sbu.softwareengineering_proposal.ui.registerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.loading_button.view.*

class RegisterFragment : Fragment(R.layout.fragment_register), RegisterContract.View {

    private lateinit var presenter: RegisterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_register)
        presenter = RegisterPresenterImpl(this)
        //setupOnClicks()
    }

    private fun setUpOnClicks() {
        registerBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkRegisterFields()) {
                //requestRegister
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_professorListFragment)
        }
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulRegister(session: SessionManager) {
        TODO("Not yet implemented")
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