package ir.sbu.softwareengineering_proposal.ui.modifyStudentByAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Student
import kotlinx.android.synthetic.main.fragment_modify_student_by_admin.*

class ModifyStudentByAdmin : Fragment(R.layout.fragment_modify_student_by_admin) {

    private lateinit var student: Student

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        student = arguments?.getParcelable("STUDENT")!!
        setupViews()
    }

    private fun setupViews() {
        firstNameEditText.setText(student.firstName)
        modifyStudentByAdminLastNameTextInput.setText(student.lastName)
        modifyStudentByAdminEmailTextInput.setText(student.email)
        modifyStudentByAdminStudentNumberTextInput.setText(student.studentNumber)
        modifyStudentByAdminEntranceYearTextInput.setText("1395")
    }

}
