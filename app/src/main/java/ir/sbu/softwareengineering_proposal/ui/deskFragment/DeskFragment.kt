package ir.sbu.softwareengineering_proposal.ui.deskFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction
import ir.sbu.softwareengineering_proposal.adapter.deskRecycler.DeskRecyclerAdapter
import ir.sbu.softwareengineering_proposal.model.DeskItem
import ir.sbu.softwareengineering_proposal.utils.addUserStr
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
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        deskRecyclerView?.apply {
            adapter = DeskRecyclerAdapter(deskItems, this@DeskFragment)
            layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupDeskItems() {
        deskItems = adminDeskItems
    }

    override fun onItemClickedListener(position: Int) {
        val name = deskItems[position].name

        when(name)
        {
            addUserStr -> findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
            else -> Toast.makeText(context, name, Toast.LENGTH_LONG).show()
        }
    }
}