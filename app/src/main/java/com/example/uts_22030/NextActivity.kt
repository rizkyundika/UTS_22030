package com.example.uts_22030

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        // Mengambil data yang dikirimkan dari Activity sebelumnya
        val judulFilm = intent.getStringExtra("judulFilm")
        val kategoriFilm = intent.getStringExtra("kategoriFilm")

        // Menampilkan data yang diterima di TextView
        val judulTextView = findViewById<TextView>(R.id.judulTextView)
        judulTextView.text = "Judul Film: $judulFilm"
        val kategoriTextView = findViewById<TextView>(R.id.kategoriTextView)
        kategoriTextView.text = "Kategori Film: $kategoriFilm"
    }
}

