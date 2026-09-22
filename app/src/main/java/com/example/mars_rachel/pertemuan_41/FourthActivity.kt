package com.example.mars_rachel.pertemuan_41

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mars_rachel.databinding.ActivityFourth4Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourth4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourth4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "FourthActivity dibuat pertama kali")

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("From")
        val age = intent.getIntExtra("age", 0)
        Log.e("Data Intent", "Nama: $name , Usia: $age, Asal: $from")

        // Tombol Kembali
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Tombol Snackbar
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(it, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    Log.e("Info Snackbar", "Snackbar ditutup")
                }
                .show()
        }

        // Tombol Alert Dialog
        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
    }
}