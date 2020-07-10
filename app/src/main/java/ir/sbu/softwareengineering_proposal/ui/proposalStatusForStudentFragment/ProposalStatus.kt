package ir.sbu.softwareengineering_proposal.ui.proposalStatusForStudentFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager

class ProposalStatus : Fragment(R.layout.fragment_proposal_status), ProposalStatusContract.View {
    override fun showToast(message: String) {
        TODO("Not yet implemented")
    }

    override fun successfulLogin(session: SessionManager) {
        TODO("Not yet implemented")
    }

    override fun showProgressBar(show: Boolean) {
        TODO("Not yet implemented")
    }

}