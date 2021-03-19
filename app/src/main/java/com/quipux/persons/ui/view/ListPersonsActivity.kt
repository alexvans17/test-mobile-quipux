package com.quipux.persons.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.ViewAnimator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quipux.persons.R
import com.quipux.persons.domain.entity.Person
import com.quipux.persons.ui.adapter.PersonAdapter
import com.quipux.persons.ui.di.component.DaggerListPersonComponent
import com.quipux.persons.ui.interfaces.view.ListPersonsView
import com.quipux.persons.ui.presenter.ListPersonsPresenterImpl
import kotlinx.android.synthetic.main.activity_persons.*
import javax.inject.Inject

class ListPersonsActivity : AppCompatActivity(), ListPersonsView {

    @Inject
    lateinit var presenter: ListPersonsPresenterImpl

    private lateinit var managerPersons: LinearLayoutManager
    private lateinit var rcViewPersons: RecyclerView
    private var personAdapter: PersonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persons)

        DaggerListPersonComponent.builder().build().inject(this)
        presenter.setView(this)

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
        managerPersons = LinearLayoutManager(this)
        personAdapter = PersonAdapter(mutableListOf(), this)

        rcViewPersons = recycler_view_person.apply {
            adapter = personAdapter
            layoutManager = managerPersons
        }
    }

    override fun onResume() {
        getAllPersons(this)
        super.onResume()
    }

    override fun getAllPersons(context: Context) {
        presenter.getAllPersons(context)
    }

    override fun setPersons(persons: MutableList<Person>?) {
        linear_empty_list?.visibility = View.GONE
        linear_person_list?.visibility = View.VISIBLE
        if (persons != null) {
            personAdapter?.updateItems(persons)
        }
    }

    override fun emptyPersons() {
        linear_empty_list?.visibility = View.VISIBLE
        linear_person_list?.visibility = View.GONE
    }
}