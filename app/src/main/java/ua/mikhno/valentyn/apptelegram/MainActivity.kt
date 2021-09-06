package ua.mikhno.valentyn.apptelegram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ua.mikhno.valentyn.apptelegram.activities.RegisterActivity
import ua.mikhno.valentyn.apptelegram.databinding.ActivityMainBinding
import ua.mikhno.valentyn.apptelegram.ui.fragments.ChatFragment
import ua.mikhno.valentyn.apptelegram.ui.objects.AppDrawer
import ua.mikhno.valentyn.apptelegram.utils.replaceActivity
import ua.mikhno.valentyn.apptelegram.utils.replaceFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolBar: Toolbar
    private lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if(false) {
            setSupportActionBar(mToolBar)
            mAppDrawer.create()
            replaceFragment(ChatFragment())
        }else{
            replaceActivity(RegisterActivity())
        }

    }

    private fun initFields() {
        mToolBar = mBinding.mainToolBar
        mAppDrawer = AppDrawer(this, mToolBar)
    }
}