package com.example.lab4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.lab4.data.Restaurante

class MainActivity : AppCompatActivity() {
    lateinit var btnnombre: Button
    lateinit var btndetalles: Button
    lateinit var infonombre: TextView
    lateinit var infodireccion: TextView
    lateinit var infohorario: TextView
    lateinit var btndirection: ImageButton
    lateinit var btndescargar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnnombre =findViewById(R.id.button3_iniciar)
        btndetalles=findViewById(R.id.button5_detalles)
        infonombre=findViewById(R.id.textView5_Restaurante)
        infodireccion=findViewById(R.id.textView8_direccion)
        infohorario=findViewById(R.id.textView9_horario)
        btndirection=findViewById(R.id.imageButton_direction)
        btndescargar=findViewById(R.id.button_descargar)
        initListeners()
    }
    fun initListeners(){
        btnnombre.setOnClickListener{
            Toast.makeText(this,getString(R.string.MiNombre),Toast.LENGTH_LONG).show()

        }
        btndetalles.setOnClickListener{
            //startActivity(Intent(this,DetailsActivity::class.java))
            val nombre = infonombre.text.toString()
            val direccion = infodireccion.text.toString()
            val horario = infohorario.text.toString()

            val restaurante = Restaurante(nombre, direccion, horario)
            val intent = Intent(this,DetailsActivity::class.java)
            intent.putExtra("EXTRA_RESTAURANTE",restaurante)
            startActivity(intent)
        }
        btndirection.setOnClickListener{
            val location ="http://maps.google.com/maps?q=loc:14.611516,-90.598076"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
            startActivity(intent)
        }
        btndescargar.setOnClickListener{
            val direction = "https://play.google.com/store/apps/details?id=com.spotify.music"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(direction))
            startActivity(intent)
        }
    }
}