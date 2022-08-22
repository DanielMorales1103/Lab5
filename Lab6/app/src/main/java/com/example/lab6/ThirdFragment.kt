package com.example.lab6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView


class ThirdFragment : Fragment(R.layout.fragment_third) {
    lateinit var iconaddbutton: ImageButton
    private var cont: Int = 0
    lateinit var textcont: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        iconaddbutton = view.findViewById(R.id.imageButtonAdd)
        textcont = view.findViewById(R.id.cont_songs)
        setListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setListener() {
        iconaddbutton.setOnClickListener(){
            cont++
            textcont.text = cont.toString()
        }
    }
}