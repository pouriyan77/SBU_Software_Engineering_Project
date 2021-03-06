package ir.sbu.softwareengineering_proposal.ui.mainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.ui.BaseActivity
import ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment.AcademicDepartmentListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sessionManager = intent.getParcelableExtra(SessionManager.SESSION_MANAGER_CONST_STR)!!
    }

//    override fun onSelectDepartment(major: Major) {
//
//    }
}