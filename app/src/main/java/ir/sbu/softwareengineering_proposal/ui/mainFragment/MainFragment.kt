package ir.sbu.softwareengineering_proposal.ui.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.mainViewPager.MainViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        viewPager?.let {
            it.adapter = MainViewPagerAdapter(childFragmentManager)
            tabLayout.setupWithViewPager(it)
            it.currentItem = 1
        }
    }

}
