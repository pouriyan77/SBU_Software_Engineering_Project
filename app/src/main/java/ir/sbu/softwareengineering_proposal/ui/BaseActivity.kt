package ir.sbu.softwareengineering_proposal.ui

import androidx.appcompat.app.AppCompatActivity
import ir.sbu.softwareengineering_proposal.session.SessionManager

open class BaseActivity : AppCompatActivity(){
    internal var sessionManager: SessionManager? = null

    override fun onDestroy() {
        super.onDestroy()
        sessionManager = null
    }
}
