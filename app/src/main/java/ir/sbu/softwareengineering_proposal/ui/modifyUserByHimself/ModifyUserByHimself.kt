package ir.sbu.softwareengineering_proposal.ui.modifyUserByHimself

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_modify_user_by_himself.*
import kotlinx.android.synthetic.main.loading_button.view.*
import androidx.navigation.fragment.findNavController
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity

class ModifyUserByHimself : Fragment(R.layout.fragment_modify_user_by_himself), ModifyUserByHimselfContract.View {

    private lateinit var presenter: ModifyUserByHimselfContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ModifyUserByHimselfPresenterImpl(this)
        setupViews()
    }

    private fun setupViews() {
        val user = (activity as MainActivity).sessionManager!!.user
        modifyBtn.button.text = "تغییر اطلاعات"
        modifyUserByHimselfEmailTextInput.setText(user.email)

        modifyBtn.button.setOnClickListener{
            showProgressBar(true)
            if (checkingModifyFields()) {
                var password: String? = null
                if (!modifyUserByHimselfPasswordTextInput.text.isNullOrBlank()){
                    password = modifyUserByHimselfPasswordTextInput.text.toString().trim()
                }
                presenter.requestModify(
                    (activity as MainActivity).sessionManager!!.authToken,
                    modifyUserByHimselfEmailTextInput.text.toString().trim(),
                    password
                )
            }
            else {
                showToast("فیلد ایمیل را پر کنید")
                showProgressBar(false)
            }
        }
    }

    private fun checkingModifyFields(): Boolean {
        return !modifyUserByHimselfEmailTextInput.text.isNullOrBlank()
    }

    override fun showToast(message: String) {

        // longToast implemented with font in ContextExtensions file check it with ctrl + click
        context?.longToast(message)
    }

    override fun successfulModify(newEmail: String) {
        showToast("تغییر اطلاعات با موفقیت انجام شد")
        (activity as MainActivity).sessionManager?.user?.email = newEmail
        findNavController().navigateUp()
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
            modifyBtn.button.text = "تغییر اطلاعات"
        }
    }


}
