package com.example.laboratorio7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var nuevoUsuario: Button
    private lateinit var inicioSesion: Button
    private lateinit var ingresoCorreoLogin : TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nuevoUsuario=view.findViewById(R.id.botonNuevoUsuarioLogin)
        inicioSesion=view.findViewById(R.id.botonIniciarSesionLogin)
        ingresoCorreoLogin=view.findViewById(R.id.ingreso_correo_login)

        setlisteners()
    }

    private fun setlisteners() {
        nuevoUsuario.setOnClickListener{
            requireView().findNavController().navigate(R.id.action_loginFragment_to_newAccountFragment)
        }
        inicioSesion.setOnClickListener{
            val texto = ingresoCorreoLogin.editText!!.text.toString()

            if (texto == "jcdurini@uvg.edu.gt"){
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                    email = texto
                )
                requireView().findNavController().navigate(action)
            }else
                Toast.makeText(requireContext(),getString(R.string.error),Toast.LENGTH_LONG).show()

        }
    }
}