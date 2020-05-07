package ir.sbu.softwareengineering_proposal.adapter.mainViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ir.sbu.softwareengineering_proposal.ui.deskFragment.DeskFragment
import ir.sbu.softwareengineering_proposal.ui.settingFragment.SettingFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager, behaviour: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT):
    FragmentStatePagerAdapter(fragmentManager, behaviour) {

    override fun getItem(position: Int): Fragment {
        return when(position)
        {
            0 -> SettingFragment()
            1 -> DeskFragment()
            else -> SettingFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position)
        {
            0 -> "تنظیمات"
            1 -> "میز کار"
            else -> "تنظیمات"
        }
    }
}