package ir.sbu.softwareengineering_proposal.ui.modifyProfessorByAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Professor
import kotlinx.android.synthetic.main.fragment_modify_professor_by_admin.*

class ModifyProfessorByAdmin : Fragment(R.layout.fragment_modify_professor_by_admin) {
    private lateinit var professor: Professor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        professor = arguments?.getParcelable("PROFESSOR")!!
        setupViews()
    }

    private fun setupViews() {
        firstNameEditText.setText(professor.firstName)
        modifyProfByAdminLastNameTextInput.setText(professor.lastName)
        modifyProfByAdminEmailTextInput.setText(professor.email)
        when(professor.degree) {
            professorAssistantRadio.text.toString() -> professorAssistantRadio.isChecked = true
            scienceAssistantRadio.text.toString() -> scienceAssistantRadio.isChecked = true
            fullProfessorRadio.text.toString() -> fullProfessorRadio.isChecked = true
            else -> fullProfessorRadio.isChecked = true
        }
    }

}
