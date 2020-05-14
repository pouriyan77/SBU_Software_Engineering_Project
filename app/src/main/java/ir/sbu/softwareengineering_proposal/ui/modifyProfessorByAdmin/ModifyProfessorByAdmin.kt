package ir.sbu.softwareengineering_proposal.ui.modifyProfessorByAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_modify_professor_by_admin.*
import kotlinx.android.synthetic.main.loading_button.view.*

class ModifyProfessorByAdmin : Fragment(R.layout.fragment_modify_professor_by_admin),
ModifyProfessorByAdminContract.View {

    private lateinit var presenter: ModifyProfessorByAdminContract.Presenter
    private lateinit var professor: Professor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ModifyProfessorByAdminPresenterImpl(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        professor = arguments?.getParcelable("PROFESSOR")!!
        setupViews()
    }

    private fun setUpOnClicks() {
        modifyProfByAdminButton.button.setOnClickListener {
            showProgressBar(true)
            if (checkModifyFields()) {
                //
            } else {
                showToast("همه فیلد ها را پر کنید")
                showProgressBar(false)
            }
        }
    }


    //to do
    private fun checkModifyFields(): Boolean {
        return true;
    }

    private fun setupViews() {
        firstNameEditText.setText(professor.firstName)
        modifyProfByAdminLastNameTextInput.setText(professor.lastName)
        modifyProfByAdminEmailTextInput.setText(professor.email)
        when (professor.degree) {
            professorAssistantRadio.text.toString() -> professorAssistantRadio.isChecked = true
            scienceAssistantRadio.text.toString() -> scienceAssistantRadio.isChecked = true
            fullProfessorRadio.text.toString() -> fullProfessorRadio.isChecked = true
            else -> fullProfessorRadio.isChecked = true
        }
    }

    override fun showToast(message: String) {
        TODO("Not yet implemented")
        context?.longToast(message)
    }

    override fun successfulModify(session: SessionManager) {
        TODO("Not yet implemented")

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
            modifyProfByAdminButton.button.text = "ورود"
        }
    }

}
