package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var firstfragment: FragmentContainerView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.Navegacion_bottom)

        setListeners()
        setFragments(FirstFragment())
    }

    private fun setListeners() {
        bottomNav.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_option_home -> setFragments(FirstFragment())
                R.id.menu_option_library -> setFragments(ThirdFragment())
                R.id.menu_option_search -> setFragments(SecondFragment())
            }
            true
        }
    }

    private fun setFragments(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.Fragment_inicial, fragment)
        }
    }

}