package com.quipux.persons.ui.di.component

import com.quipux.persons.ui.di.module.AuthModule
import com.quipux.persons.ui.view.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AuthModule::class])
interface AuthComponent {
    fun inject(loginActivity: LoginActivity)
}