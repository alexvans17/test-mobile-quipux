package com.quipux.persons.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.quipux.persons.R
import kotlinx.android.synthetic.main.activity_persons.*

class ListPersonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persons)

        button_add_person?.setOnClickListener {
            if (switch_allow_add_person!!.isChecked) {
                val intent = Intent(this, RegisterPersonActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.not_add_person),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}