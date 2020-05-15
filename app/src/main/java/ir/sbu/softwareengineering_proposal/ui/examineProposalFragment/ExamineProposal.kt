package ir.sbu.softwareengineering_proposal.ui.examineProposalFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import kotlinx.android.synthetic.main.fragment_examine_proposal.*
import kotlinx.android.synthetic.main.loading_button.view.*

/**
 * A simple [Fragment] subclass.
 */
class ExamineProposal : Fragment(), ExamineProposalContract.View {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_examine_proposal, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setupOnClicks() {
        examineProposalBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkExamineProposalFields()) {

            } else {

            }
        }
    }

    private fun checkExamineProposalFields(): Boolean {
        return true;
    }

    override fun showToast(message: String) {
        TODO("Not yet implemented")
    }

    override fun successfulLogin(session: SessionManager) {
        TODO("Not yet implemented")
    }

    override fun showProgressBar(show: Boolean) {
        examineProposalBtn.button.isEnabled = !show
        if (show) {
            examineProposalBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            examineProposalBtn.button.text = ""
        } else {
            examineProposalBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            examineProposalBtn.button.text = "داوری پروپوزال"
        }
    }

}
