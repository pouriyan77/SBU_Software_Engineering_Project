package ir.sbu.softwareengineering_proposal.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity

abstract class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    lateinit var myActivity: MainActivity
    private set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myActivity = requireActivity() as MainActivity
    }
}