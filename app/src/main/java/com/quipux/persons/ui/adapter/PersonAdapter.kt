package com.quipux.persons.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.quipux.persons.R
import com.quipux.persons.domain.entity.Person
import kotlinx.android.synthetic.main.item_list_persons.view.*

class PersonAdapter (
    private var data: MutableList<Person>,
    val context: Context
): RecyclerView.Adapter<PersonAdapter.ViewHolderPerson>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPerson =
        ViewHolderPerson(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_persons, parent, false))


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolderPerson, position: Int) {
        val person = data[position]
        holder.documentType.text = person.documentType
        holder.documentNumber.text = person.documentNumber
        holder.firstName.text = person.firstName
        holder.lastName.text = person.lastName
        holder.gender.text = person.gender
        holder.age.text = person.age.toString()

        if (person.gender == "Femenino"){
            holder.linearPersons.setBackgroundColor(ContextCompat.getColor(this.context, R.color.gender))
        }else{
            holder.linearPersons.setBackgroundColor(ContextCompat.getColor(this.context, R.color.card_view))
        }

        holder.delete.setOnClickListener {

        }
    }

    fun updateItems(items : MutableList<Person>){
        this.data.clear()
        this.data.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolderPerson(view: View) : RecyclerView.ViewHolder(view) {
        val documentType: TextView =  view.text_view_document_type
        val documentNumber: TextView = view.text_view_document_number
        val firstName: TextView = view.text_view_first_name
        val lastName: TextView = view.text_view_last_name
        val gender: TextView = view.text_view_document_gender
        val age: TextView = view.text_view_age
        val delete: ImageView = itemView.image_view_delete
        val linearPersons: LinearLayout = itemView.linear_persons
    }
}

