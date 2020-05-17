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
import ir.sbu.softwareengineering_proposal.model.Professor
import ir.sbu.softwareengineering_proposal.ui.BaseFragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_professor_list.*

class ProfessorListFragment : BaseFragment(R.layout.fragment_professor_list),
    RecyclerViewInteraction, ProfessorListContract.View {

    private lateinit var professorList: List<Professor>
    private lateinit var presenter: ProfessorListContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ProfessorListPresenterImpl(this)
        requestProfessorList()
    }

    private fun requestProfessorList(){
        showProgressBar(true)
        presenter.requestProfessorList((activity as MainActivity).sessionManager!!.authToken)
    }

    private fun setupRecyclerView(professorList: List<Professor>) {
        this.professorList = professorList
        professorsRecyclerView?.apply {
            adapter = ProfessorsRecyclerAdapter(professorList, this@ProfessorListFragment)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {

    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            myActivity.loadingProgressBar.visibility = View.VISIBLE
        }else{
            myActivity.loadingProgressBar.visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulDefine() {

    }

    override fun successfulLoad(professorList: List<Professor>) {
        setupRecyclerView(professorList)
    }
}
