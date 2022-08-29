package com.example.laboratorio7

import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var botonActualizarPerfil: Button
    private lateinit var correoProfile : TextInputLayout
    private val args: ProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botonActualizarPerfil = view.findViewById(R.id.botonActualizar)
        correoProfile=view.findViewById(R.id.ingreso_correo_profile)

        val textoEmailProfile = args.email
        correoProfile.hint = textoEmailProfile.toString()
        setlisteners()
    }

    private fun setlisteners() {
        botonActualizarPerfil.setOnClickListener{
            requireView().findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }
    }
}