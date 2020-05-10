package ir.sbu.softwareengineering_proposal.ui.professorListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.professorsRecycler.ProfessorsRecyclerAdapter
import ir.sbu.softwareengineering_proposal.utils.fakeProfessors
import kotlinx.android.synthetic.main.fragment_professor_list.*

class ProfessorListFragment : Fragment(R.layout.fragment_professor_list), RecyclerViewInteraction {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        professorsRecyclerView?.apply {
            adapter = ProfessorsRecyclerAdapter(fakeProfessors, this@ProfessorListFragment)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {

    }
}
