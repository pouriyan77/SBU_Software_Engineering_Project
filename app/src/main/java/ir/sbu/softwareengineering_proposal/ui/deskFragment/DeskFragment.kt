package ir.sbu.softwareengineering_proposal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.deskRecycler.DeskRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.DeskItem
import ir.sbu.softwareengineering_proposal.utils.adminDeskItems
import kotlinx.android.synthetic.main.fragment_desk.*

class DeskFragment : Fragment(R.layout.fragment_desk), RecyclerViewInteraction {

    private lateinit var deskItems: List<DeskItem>

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setupDeskItems()
        deskRecyclerView.adapter = DeskRecyclerAdapter(adminDeskItems, this)
    }

    private fun setupDeskItems() {
        deskItems = adminDeskItems
    }

    override fun onItemClickedListener(position: Int) {
        Toast.makeText(this, )
    }
}