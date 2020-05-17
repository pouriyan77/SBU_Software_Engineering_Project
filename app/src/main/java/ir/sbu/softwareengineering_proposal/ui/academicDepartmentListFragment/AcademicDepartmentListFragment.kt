package ir.sbu.softwareengineering_proposal.ui.academicDepartmentListFragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.MarginSpacingItemDecoration
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.academicDepartmentRecycler.AcademicDepartmentRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.Major
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_academic_department_list.*


class AcademicDepartmentListFragment() : DialogFragment(),
    RecyclerViewInteraction, AcademicDepartmentListContract.View {

    private lateinit var presenter: AcademicDepartmentListContract.Presenter
    private var onSelectDepartmentListener: OnSelectDepartmentListener? = null
    private lateinit var majorList: List<Major>

    constructor(onSelectDepartmentListener: OnSelectDepartmentListener) : this() {
        this.onSelectDepartmentListener = onSelectDepartmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_academic_department_list, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        presenter = AcademicDepartmentListPresenterImpl(this)
        requestMajors()
    }

    override fun onResume() {
        super.onResume()
        val width = resources.getDimensionPixelSize(R.dimen.popupWidth)
        val height = resources.getDimensionPixelSize(R.dimen.popupHeight)
        val window: Window? = dialog!!.window
        window?.setLayout(width, height)
        window?.setGravity(Gravity.CENTER)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return super.onCreateDialog(savedInstanceState)
    }

    private fun requestMajors() {
        showProgressBar(true)
        presenter.requestMajors((activity as MainActivity).sessionManager!!.authToken)
    }

    private fun setupRecyclerView(majors: List<Major>) {
        majorList = majors
        academicDepartmentRecyclerView?.apply {
            adapter = AcademicDepartmentRecyclerAdapter(majors, this@AcademicDepartmentListFragment)
            addItemDecoration(MarginSpacingItemDecoration(20))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClickedListener(position: Int) {
        onSelectDepartmentListener?.onSelectDepartment(majorList[position])
    }

    override fun showProgressBar(show: Boolean) {
        if(show){
            progressBar?.visibility = View.VISIBLE
        }else{
            progressBar?.visibility = View.GONE
        }
    }

    override fun showToast(message: String) {
        context?.longToast(message)
    }

    override fun successfulMajorList(majorList: List<Major>) {
        setupRecyclerView(majorList)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSelectDepartmentListener) {
            onSelectDepartmentListener = context
        }
    }

    interface OnSelectDepartmentListener {
        fun onSelectDepartment(major: Major)
    }
}
