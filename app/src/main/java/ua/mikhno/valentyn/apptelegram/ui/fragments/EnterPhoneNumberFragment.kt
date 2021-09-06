package ua.mikhno.valentyn.apptelegram.ui.fragments

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import ua.mikhno.valentyn.apptelegram.R
import ua.mikhno.valentyn.apptelegram.utils.replaceFragment
import ua.mikhno.valentyn.apptelegram.utils.showToast

class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {

    override fun onStart() {
        super.onStart()

        register_btn_next.setOnClickListener {
            sendCode()
        }
    }

    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()) {
            showToast("Введите номер телефона")
        }else{
            replaceFragment(EnterCodeFragment())
        }
    }

}