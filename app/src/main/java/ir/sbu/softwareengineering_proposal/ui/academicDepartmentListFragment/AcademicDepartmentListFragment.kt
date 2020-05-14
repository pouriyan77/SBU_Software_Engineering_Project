package ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.academicDepartmentRecycler.AcademicDepartmentRecyclerAdapter
import ir.sbu.softwareengineering_proposal.adapter.professorsRecycler.ProfessorsRecyclerAdapter
import ir.sbu.softwareengineering_proposal.utils.fakeAcademicList
import kotlinx.android.synthetic.main.fragment_academic_department_list.*
import kotlinx.android.synthetic.main.fragment_professor_list.*

class AcademicDepartmentListFragment : Fragment(R.layout.fragment_academic_department_list),
    RecyclerViewInteraction {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        academicDepartmentRecyclerView?.apply {
            adapter = AcademicDepartmentRecyclerAdapter(fakeAcademicList)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {

    }
}
