package ir.sbu.softwareengineering_proposal.ui.uploadProposalFragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.session.SessionManager
import ir.sbu.softwareengineering_proposal.utils.longToast
import kotlinx.android.synthetic.main.fragment_upload_proposal.*
import kotlinx.android.synthetic.main.loading_button.view.*


class UploadProposal : Fragment(R.layout.fragment_upload_proposal), UploadProposalContract.View {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar(false)
        setupOnClicks()
    }

    private fun checkUploadProposalFields(): Boolean {
        return true
    }

    private fun setupOnClicks() {
        uploadProposalBtn.setOnClickListener {
            if (checkUploadProposalFields()) {
                val intent = Intent()
                    .setType("file/*")
                    .setAction(Intent.ACTION_GET_CONTENT)

                startActivityForResult(
                    Intent.createChooser(intent, "Select a file"),
                    123
                )

            } else {

            }
        }

        uploadFinalProposal.button.setOnClickListener {
            showProgressBar(true)
            val handler = Handler()
            handler.postDelayed({
                showProgressBar(false)
                showToast("پروپوزال با موفقیت آپلود شد")
                findNavController().navigateUp()
            }, 2000)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val splittedData = data?.dataString?.split("/")
        val fileName = splittedData?.get(splittedData.size - 1)
        proposalFileName.text = fileName
    }


    override fun showToast(message: String) {
        requireContext().longToast(message)
    }

    override fun successfulLogin(session: SessionManager) {

    }

    override fun showProgressBar(show: Boolean) {
        uploadFinalProposal.button.isEnabled = !show
        if (show) {
            uploadFinalProposal.button.background =
                resources.getDrawable(R.drawable.loading_button_selector, null)
            uploadFinalProposal.button.text = ""
        } else {
            uploadFinalProposal.button.background =
                resources.getDrawable(R.drawable.login_button_selector, null)
            uploadFinalProposal.button.text = "آپلود"
        }
    }

}
