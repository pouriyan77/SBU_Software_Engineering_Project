package ir.sbu.softwareengineering_proposal.ui.modifyUserByHimself

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_modify_user_by_himself.*
import kotlinx.android.synthetic.main.loading_button.view.*

class ModifyUserByHimself : Fragment(R.layout.fragment_modify_user_by_himself), ModifyUserByHimselfContract.View {

    private lateinit var presenter: ModifyUserByHimselfContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        presenter = ModifyUserByHimselfPresenterImpl(this)
        //setupOnClicks()
    }

    private fun checkingModifyFields(): Boolean {
        return !modifyUserByHimselfEmailTextInput.text.isNullOrBlank()
    }

    private fun setupOnClicks() {
        modifyBtn.button.setOnClickListener{
            showProgressBar(true)
            if (checkingModifyFields()) {
                //request
            }
            else {
                showToast("فیلد ایمیل را پر کنید")
                showProgressBar(false)
            }
        }
    }

    override fun showToast(message: String) {

        // longToast implemented with font in ContextExtensions file check it with ctrl + click
        context?.longToast(message)
    }

    override fun successfulModify(session: SessionManager) {
        TODO("Not yet implemented")
    }

    override fun showProgressBar(show: Boolean) {
        modifyBtn.button.isEnabled = !show
        if (show){
            modifyBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            modifyBtn.button.text = ""
        }else{
            modifyBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            modifyBtn.button.text = "ورود"
        }
    }


}
