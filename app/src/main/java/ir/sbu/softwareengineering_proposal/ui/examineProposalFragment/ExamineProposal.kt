package ir.sbu.softwareengineering_proposal.ui.examineProposalFragment

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.sbu.softwareengineering_proposal.R
import ir.sbu.softwareengineering_proposal.model.Proposal
import ir.sbu.softwareengineering_proposal.ui.mainActivity.MainActivity
import ir.sbu.softwareengineering_proposal.utils.longToast
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
        setupOnClicks()
    }

    private fun setupViews() {
        proposalTitleTextView.text = proposal.persianTitle
        studentNameProposalTextView.text = getString(
            R.string.fullNameStr, proposal.owner.firstName, proposal.owner.lastName
        )
        keywordsForProposal.text = proposal.persianKeywords
        downloadProposal.button.text = "دانلود پروپوزال"
        examineProposalBtn.button.text = "ثبت داوری"
    }

    private fun setupOnClicks() {
        examineProposalBtn.button.setOnClickListener {
            showProgressBar(true)
            if (checkExamineProposalFields()) {
                val checkedStatusRadio =
                    view?.findViewById<RadioButton>(examineProposalRadioGroup.checkedRadioButtonId)
                val status = when (checkedStatusRadio?.text.toString().trim()) {
                    "تایید" -> "accept"
                    "اصلاح" -> "miner"
                    else -> "decline"
                }
                val checkedBeforeOrAfterRadio =
                    view?.findViewById<RadioButton>(beforeAndAfterPresentation.checkedRadioButtonId)
                val beforeOrAfter = when (checkedBeforeOrAfterRadio?.text.toString().trim()) {
                    "قبل از دفاع" -> "before"
                    else -> "after"
                }
                presenter.requestExamine(
                    (requireActivity() as MainActivity).sessionManager?.authToken!!,
                    status,
                    professorCommentOnProposalEditText.text.toString(),
                    proposal.proposalId,
                    beforeOrAfter
                )
            } else {

            }
        }
        downloadProposal.button.setOnClickListener {
            val permissionCheck =
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )

            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1010
                )
            } else {
                downloadProposal()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1010) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                downloadProposal()
            }
        }
    }

    private fun downloadProposal() {
        val downloadManager =
            requireActivity().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri =
            Uri.parse(
                "http://s13.picofile.com/d/8402479668/8e2a6884-5c1b-4578-9215-bbd7fd2b1783/SEII_98_Bahman_ProjectDesc.pdf"
            )

        val request = DownloadManager.Request(uri)
        request.setTitle("Proposal")
        request.setDescription("Downloading")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            "SEII_98_Bahman_ProjectDesc.pdf"

        )
        request.setMimeType("application/pdf")

        downloadManager.enqueue(request)
    }

    private fun checkExamineProposalFields(): Boolean {
        return true
    }

    override fun showToast(message: String) {
        requireContext().longToast(message)
    }

    override fun successfulSubmit() {
        showToast("ثبت نظر با موفقیت انجام شد")
        findNavController().navigateUp()
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
