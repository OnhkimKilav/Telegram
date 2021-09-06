package ua.mikhno.valentyn.apptelegram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import ua.mikhno.valentyn.apptelegram.R
import ua.mikhno.valentyn.apptelegram.databinding.ActivityRegisterBinding
import ua.mikhno.valentyn.apptelegram.ui.fragments.EnterPhoneNumberFragment
import ua.mikhno.valentyn.apptelegram.utils.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        mToolBar = mBinding.registerToolBar
        setSupportActionBar(mToolBar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment())
    }
}