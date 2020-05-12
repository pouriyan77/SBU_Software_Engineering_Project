package ir.sbu.softwareengineering_proposal.ui.loginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.FrameLayout
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import ir.sbu.softwareengineering_proposal.utils.shortToast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.loading_button.view.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenterImpl(this)
        setupOnClicks()
    }

    private fun setupOnClicks() {
        loginBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkLoginFields()){
                presenter.requestLogin(
                    nationalCodeEditText.text!!.toString(), passwordEditText.text!!.toString())
            }
            else{
                showToast("لطفا همه فیلدها را پر کنید")
                showProgressBar(false)
            }
        }
    }

    private fun checkLoginFields(): Boolean{
        return !nationalCodeEditText.text.isNullOrBlank() && !passwordEditText.text.isNullOrBlank()
    }

    override fun showToast(message: String) {

        // longToast implemented with font in ContextExtensions file check it with ctrl + click
        longToast(message)
    }

    override fun successfulLogin(session: SessionManager) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(SessionManager.SESSION_MANAGER_CONST_STR, session)
        startActivity(intent)
        finish()
    }

    override fun showProgressBar(show: Boolean) {
        loginBtn.button.isEnabled = !show
        if (show){
            loginBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            loginBtn.button.text = ""
        }else{
            loginBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            loginBtn.button.text = "ورود"
        }
    }
}
