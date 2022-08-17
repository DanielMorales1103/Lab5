package com.example.lab4

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import com.example.lab4.data.Restaurante
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class DetailsActivity : AppCompatActivity() {
    lateinit var NombreRestaurante:TextView
    lateinit var DireccionRestaurante: TextView
    lateinit var HorarioRestaurante: TextView
    lateinit var btnllamar: Button
    lateinit var btncamara:Button
    lateinit var rootLayout:ConstraintLayout

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        NombreRestaurante = findViewById(R.id.textView_NombreRestaurante)
        DireccionRestaurante = findViewById(R.id.textView2_DireccionRestaurante)
        HorarioRestaurante=findViewById(R.id.textView5_Horario)
        btnllamar=findViewById(R.id.button4_llamar)
        btncamara=findViewById(R.id.button3_IniciarVista)
        rootLayout=findViewById(R.id.root_detailsActivity)

        val rest: Restaurante=intent.getSerializableExtra("EXTRA_RESTAURANTE") as Restaurante
        NombreRestaurante.text=rest.nombre
        DireccionRestaurante.text=rest.direccion
        HorarioRestaurante.text=rest.horario

        initlisteners()
    }
    private fun hasCameraPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    private fun checkCameraPermission(){
        if (!hasCameraPermission()) {
            checkRequestRationale()
        } else {
            Toast.makeText(this, "Permiso otorgado, abrir camara", Toast.LENGTH_LONG).show()
        }
    }
    private fun checkRequestRationale() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                val snackbar = Snackbar.make(
                    rootLayout,
                    "Acceso a cámara es necesario para poder tomar fotos",
                    Snackbar.LENGTH_INDEFINITE
                )
                snackbar.setAction("Ok"){
                    requestCameraPermission()
                }
                snackbar.show()
            } else {
                requestCameraPermission()
            }
        }
    }
    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),0)

    }
    private fun initlisteners(){
        btnllamar.setOnClickListener{
            val telnum = "22317373"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telnum"))
            startActivity(intent)
        }
        btncamara.setOnClickListener{
            checkCameraPermission()

        }
    }
}