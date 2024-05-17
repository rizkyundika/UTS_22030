package com.example.uts_22030

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class FilmActivity : AppCompatActivity() {
    var editText: EditText? = null
    var spinner: Spinner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        // Inisialisasi elemen UI
        editText = findViewById(R.id.editTextText)
        spinner = findViewById(R.id.spinner)

        // Setting up onClickListener for Button
        val okButton = findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener { // Membuat intent untuk berpindah ke halaman berikutnya
            val intent = Intent(
                this@FilmActivity,
                NextActivity::class.java
            )
            // Menambahkan data judul film ke intent
            intent.putExtra("judulFilm", editText.getText().toString())
            // Menambahkan data spinner yang dipilih ke intent
            intent.putExtra("kategoriFilm", spinner.getSelectedItem().toString())
            startActivity(intent)
        }

        // Setting up onItemSelectedListener for Spinner
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                // Do something when an item is selected
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do something when nothing is selected
            }
        })

        // Inisialisasi Spinner untuk tahun, jam, dan menit
        val tahunSpinner = findViewById<Spinner>(R.id.spinner)
        val jamSpinner = findViewById<Spinner>(R.id.spinner2)
        val menitSpinner = findViewById<Spinner>(R.id.spinner3)

        // Membuat array untuk opsi-opsi Spinner
        val tahunOptions = arrayOf("2020", "2021", "2022", "2023", "2024")
        val jamOptions = arrayOf("00", "01", "02", "03" ,"4", "5", "6", "7", "8", "9", "10")
        val menitOptions = arrayOf("00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55")

        // Membuat adapter untuk setiap Spinner
        val tahunAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tahunOptions)
        val jamAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jamOptions)
        val menitAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, menitOptions)

        // Menentukan tata letak untuk adapter
        tahunAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        jamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        menitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Mengatur adapter ke Spinner
        tahunSpinner.setAdapter(tahunAdapter)
        jamSpinner.setAdapter(jamAdapter)
        menitSpinner.setAdapter(menitAdapter)
    }
}

