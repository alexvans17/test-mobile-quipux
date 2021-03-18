package com.quipux.persons.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.quipux.persons.R
import com.quipux.persons.data.model.LoggedInUser
import com.quipux.persons.ui.di.component.DaggerAuthComponent
import com.quipux.persons.ui.interfaces.view.AuthView
import com.quipux.persons.ui.presenter.AuthPresenterImpl
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(),
    AuthView {

    private var username: EditText? = null
    private var password: EditText? = null
    private var btnLogin: Button? = null

    @Inject
    lateinit var presenter: AuthPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        DaggerAuthComponent.builder().build().inject(this)
        presenter.setView(this)

        username = edit_text_username
        password = edit_text_password
        btnLogin = button_login

        password?.apply {
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        login(username?.text.toString(), password?.text.toString())
                }
                false
            }

            btnLogin?.setOnClickListener {
                login(username?.text.toString(), password?.text.toString())
            }
        }
    }

    override fun login(username: String, password: String) {
        progress_bar_loading?.visibility = View.VISIBLE
        presenter.login(username, password)
    }

    override fun successLogin(fakeUser: LoggedInUser) {
        val intent = Intent(this, ListPersonsActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun failLogin(message: String) {
        progress_bar_loading?.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
