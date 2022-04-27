package com.musnadil.chapter6mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.musnadil.chapter6mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    lateinit var presenterImp: MainPresenterImp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenterImp = MainPresenterImp(this)
        binding.btnAdd.setOnClickListener {
            presenterImp.addJumlah(
                binding.angka1.text.toString(),
                binding.angka2.text.toString()
            )
        }
        binding.btnShow.setOnClickListener {
            presenterImp.loadData()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun clearField() {
        binding.angka1.text.clear()
        binding.angka2.text.clear()
    }

    override fun showData(data: String) {
        AlertDialog.Builder(this)
            .setTitle("History")
            .setNegativeButton("close"){dialog,_->
                dialog.dismiss()

            }
            .setMessage(data)
            .create()
            .show()

    }
}