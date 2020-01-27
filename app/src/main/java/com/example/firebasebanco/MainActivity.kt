package com.example.firebasebanco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dao = Dao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val firebaseBanco = FirebaseBanco()

            firebaseBanco.nome = idEmail.text.toString()
            idEmail.text = null

            firebaseBanco.sobronome = idPass.text.toString()
            idPass.text = null

            dao.salvarInformacoes(firebaseBanco)
        }
    }

    override fun onResume() {
        super.onResume()

        dao.getBanco {
            idEmail.setText(it?.nome?:"")
            idPass.setText(it?.sobronome?:"")
        }
    }
}
