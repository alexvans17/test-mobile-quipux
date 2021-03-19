package com.quipux.persons.presenter

import com.quipux.persons.domain.interactor.AuthInteractorImpl
import com.quipux.persons.ui.interfaces.view.AuthView
import com.quipux.persons.ui.presenter.AuthPresenterImpl
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AuthPresenterImplTest {

    private lateinit var authPresenter: AuthPresenterImpl

    @Mock
    private lateinit var authInteractor: AuthInteractorImpl

    @Mock
    private lateinit var view: AuthView

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        authPresenter = AuthPresenterImpl(authInteractor)
        authPresenter.setView(view)
    }

    @Test
    fun login(){
        var message = ""
        val loginMessage = "login"

        doAnswer { message = loginMessage }.`when`(authInteractor).login("user", "123")
        authPresenter.login("user", "123")
        assertEquals(message, loginMessage)
    }

    @Test
    fun setView(){
        assertTrue(authPresenter.setView(view))
    }

    @Test
    fun failLogin(){
        var expect = true
        doAnswer { expect = false }.`when`(authInteractor).login("user", "123")
        authPresenter.login("user", "1234")
        assert(expect)
    }
}