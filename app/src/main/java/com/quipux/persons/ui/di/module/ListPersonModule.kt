package com.quipux.persons.ui.di.module

import com.quipux.persons.data.datasource.database.ListPersonsDataBaseImpl
import com.quipux.persons.data.repository.ListPersonsRepositoryImpl
import com.quipux.persons.domain.interactor.ListPersonsInteractorImpl
import com.quipux.persons.ui.presenter.ListPersonsPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ListPersonModule {

    @Provides
    @Singleton
    fun provideListPersonImpl()= ListPersonsDataBaseImpl()

    @Provides
    @Singleton
    fun provideListPersonRepositoryImpl(
        listPersonDataBaseImpl: ListPersonsDataBaseImpl
    ) = ListPersonsRepositoryImpl(listPersonDataBaseImpl)

    @Provides
    @Singleton
    fun provideListPersonInteractorImpl(
        listPersonRepositoryImpl: ListPersonsRepositoryImpl
    )= ListPersonsInteractorImpl(listPersonRepositoryImpl)

    @Provides
    @Singleton
    fun provideListPersonPresenterImpl(
        listPersonInteractorImpl: ListPersonsInteractorImpl
    ) = ListPersonsPresenterImpl(listPersonInteractorImpl)
}