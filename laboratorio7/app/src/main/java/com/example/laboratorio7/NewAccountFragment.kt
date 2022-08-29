package com.example.laboratorio7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout


class NewAccountFragment : Fragment(R.layout.fragment_new_account) {
    private lateinit var crearCuenta : Button
    private lateinit var ingresoCorreoNewaccount : TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crearCuenta=view.findViewById(R.id.botonCrearCuenta)
        ingresoCorreoNewaccount=view.findViewById(R.id.ingreso_correo_newAccount)
        setlisteners()

    }

    private fun setlisteners() {
        crearCuenta.setOnClickListener{
            val texto = ingresoCorreoNewaccount.editText?.text.toString()
            val action = NewAccountFragmentDirections.actionNewAccountFragmentToHomeFragment(
                email = texto
            )
            requireView().findNavController().navigate(action)
        }
    }
}