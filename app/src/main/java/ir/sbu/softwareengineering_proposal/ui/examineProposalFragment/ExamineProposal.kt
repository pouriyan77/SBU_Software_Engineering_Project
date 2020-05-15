package ir.sbu.softwareengineering_proposal.ui.examineProposalFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.session.SessionManager
import kotlinx.android.synthetic.main.fragment_examine_proposal.*
import kotlinx.android.synthetic.main.loading_button.view.*

class ExamineProposal : Fragment(R.layout.fragment_examine_proposal), ExamineProposalContract.View {

    private lateinit var presenter: ExamineProposalContract.Presenter
    private lateinit var proposal: Proposal

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ExamineProposalPresenterImpl(this)
        proposal = requireArguments().getParcelable("PROPOSAL")!!
        setupViews()
    }

    private fun setupViews() {
        proposalTitleTextView.text = proposal.persianTitle
        studentNameProposalTextView.text = getString(
            R.string.fullNameStr, proposal.owner.firstName, proposal.owner.lastName)
        keywordsForProposal.text = proposal.persianKeywords
        downloadProposal.button.text = "دانلود پروپوزال"
        examineProposalBtn.button.text = "ثبت داوری"
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

    }

    override fun successfulLogin(session: SessionManager) {

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
            examineProposalBtn.button.text = "ثبت داوری"
        }
    }

}
