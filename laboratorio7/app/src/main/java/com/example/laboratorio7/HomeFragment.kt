package com.example.laboratorio7

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var botonactualizar: Button
    private lateinit var textSaludo: TextView
    private val args: HomeFragmentArgs by navArgs()
    lateinit var textoEmail: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        botonactualizar=view.findViewById(R.id.botonActualizarPerfilHome)
        textSaludo=view.findViewById(R.id.saludoHome)
        textoEmail = args.email

        textSaludo.text = getString(R.string.saludo1) +" "+ textoEmail + " "+getString(R.string.saludo2)
        setlisteners()
    }

    private fun setlisteners() {
        botonactualizar.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment(
                email = textoEmail
            )
            requireView().findNavController().navigate(action)

        }
    }
}