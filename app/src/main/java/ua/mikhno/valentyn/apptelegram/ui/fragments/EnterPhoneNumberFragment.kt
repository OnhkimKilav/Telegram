package ua.mikhno.valentyn.apptelegram.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import ua.mikhno.valentyn.apptelegram.R

class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {

    override fun onStart() {
        super.onStart()

        register_btn_next.setOnClickListener {
            sendCode()
        }
    }

    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()) {
            Toast.makeText(activity, "Введите номер телефона", Toast.LENGTH_SHORT).show()
        }else{
            parentFragmentManager.beginTransaction()
                .replace(R.id.registerDataContainer, EnterCodeFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}