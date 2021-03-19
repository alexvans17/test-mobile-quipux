package com.quipux.persons.ui.di.component

import com.quipux.persons.ui.di.module.RegisterPersonModule
import com.quipux.persons.ui.view.RegisterPersonActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RegisterPersonModule::class])
interface RegisterPersonComponent {
    fun inject(registerActivity: RegisterPersonActivity)
}