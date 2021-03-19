package com.quipux.persons.ui.di.component

import com.quipux.persons.ui.di.module.ListPersonModule
import com.quipux.persons.ui.view.ListPersonsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ListPersonModule::class])
interface ListPersonComponent {
    fun inject(listActivity: ListPersonsActivity)
}