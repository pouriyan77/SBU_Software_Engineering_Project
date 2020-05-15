package ir.sbu.softwareengineering_proposal.ui.uploadProposalFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import kotlinx.android.synthetic.main.fragment_upload_proposal.*
import kotlinx.android.synthetic.main.loading_button.view.*

class UploadProposal : Fragment(R.layout.fragment_upload_proposal), UploadProposalContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun checkUploadProposalFields(): Boolean {
        return true
    }

    private fun setupOnClicks() {
        uploadProposalBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkUploadProposalFields()) {

            } else {

            }
        }
    }


    override fun showToast(message: String) {

    }

    override fun successfulLogin(session: SessionManager) {

    }

    override fun showProgressBar(show: Boolean) {
        uploadProposalBtn.button.isEnabled = !show
        if (show) {
            uploadProposalBtn.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            uploadProposalBtn.button.text = ""
        } else {
            uploadProposalBtn.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            uploadProposalBtn.button.text = "آپلود پروپوزال"
        }
    }

}
