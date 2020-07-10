package ir.sbu.softwareengineering_proposal.ui.professorListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.professorsRecycler.ProfessorsRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.ui.BaseActivity
import ir.sbu.softwareengineering_proposal.ui.BaseFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.PROPOSAL_LIST_ADMIN_TYPE
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_professor_list.*

class ProfessorListFragment : BaseFragment(R.layout.fragment_professor_list),
    RecyclerViewInteraction, ProfessorListContract.View {

    private lateinit var professorList: List<Professor>
    private lateinit var presenter: ProfessorListContract.Presenter
    private lateinit var professorsRecyclerAdapter: ProfessorsRecyclerAdapter
    private lateinit var selectedProfessorList: MutableList<Professor>
    private var proposal: Proposal? = null
    private var professorListType: Int = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ProfessorListPresenterImpl(this)
        professorListType = requireArguments().getInt("LIST_TYPE", -1)
        proposal = requireArguments().getParcelable("PROPOSAL")
        selectedProfessorList = mutableListOf()
        requestProfessorList()
        setupOnClicks()
    }

    private fun setupOnClicks() {
        submitRefereesBtn.setOnClickListener{
            presenter.requestDefiningReferees(
                (activity as MainActivity).sessionManager!!.authToken,
                selectedProfessorList[0].profId,
                selectedProfessorList[1].profId,
                proposal!!.proposalId
            )
        }
    }

    private fun requestProfessorList(){
        showProgressBar(true)
        presenter.requestProfessorList((activity as MainActivity).sessionManager!!.authToken)
    }

    private fun setupRecyclerView(professorList: List<Professor>) {
        this.professorList = professorList
        professorsRecyclerView?.apply {
            professorsRecyclerAdapter = ProfessorsRecyclerAdapter(professorList, this@ProfessorListFragment)
            adapter = professorsRecyclerAdapter
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {
        if (professorListType == PROPOSAL_LIST_ADMIN_TYPE) {
            handleDefineSupervisor(position)
        } else {
            handleDefineReferee(position)
        }
    }

    private fun handleDefineReferee(position: Int) {
        val professor = professorList[position]
        professor.selected = !professor.selected
        professorsRecyclerAdapter.notifyItemChanged(position)
        if (professor.selected) {
            selectedProfessorList.add(professor)
        } else {
            selectedProfessorList.remove(professor)
        }
        if (selectedProfessorList.size == 2) {
            submitRefereesBtn.visibility = View.VISIBLE
        } else {
            submitRefereesBtn.visibility = View.GONE
        }
    }

    private fun handleDefineSupervisor(position: Int) {
        showProgressBar(true)
        presenter.requestDefiningSupervisor(
            (activity as MainActivity).sessionManager!!.authToken,
            proposal!!.owner.stdId,
            proposal!!.proposalId,
            professorList[position].profId
        )
    }


    override fun showProgressBar(show: Boolean) {
        if (show) {
            myActivity.loadingProgressBar.visibility = View.VISIBLE
        }else{
            myActivity.loadingProgressBar.visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        requireContext().longToast(message)
    }

    override fun successfulSupervisorDefine() {
        showToast("استاد راهنما تعیین شد")
        findNavController().navigateUp()
    }

    override fun successfulRefereeDefine() {
        showToast("داوران تعیین شدند")
        findNavController().navigateUp()
    }

    override fun successfulLoad(professorList: List<Professor>) {
        setupRecyclerView(professorList)
    }
}
