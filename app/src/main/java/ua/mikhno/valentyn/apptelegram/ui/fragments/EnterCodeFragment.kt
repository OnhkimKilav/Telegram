package ua.mikhno.valentyn.apptelegram.ui.fragments

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enter_code.*
import ua.mikhno.valentyn.apptelegram.R
import ua.mikhno.valentyn.apptelegram.utils.AppTextWatcher

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 5) {
                verificationCode()
            }
        })
    }

    private fun verificationCode() {
        Toast.makeText(activity, "Ok", Toast.LENGTH_SHORT).show()
    }
}