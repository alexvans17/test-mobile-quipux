package com.quipux.persons.ui.di.module

import com.quipux.persons.data.datasource.database.DataBaseRegisterPersonImpl
import com.quipux.persons.data.repository.RegisterPersonRepositoryImpl
import com.quipux.persons.domain.interactor.RegisterPersonInteractorImpl
import com.quipux.persons.ui.presenter.RegisterPersonsPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RegisterPersonModule {

    @Provides
    @Singleton
    fun provideDataBaseRegisterPersonImpl()= DataBaseRegisterPersonImpl()

    @Provides
    @Singleton
    fun provideRegisterPersonRepositoryImpl(
        dataBaseRegisterPersonImpl: DataBaseRegisterPersonImpl
    ) = RegisterPersonRepositoryImpl(dataBaseRegisterPersonImpl)

    @Provides
    @Singleton
    fun provideRegisterPersonInteractorImpl(
        registerPersonRepositoryImpl: RegisterPersonRepositoryImpl
    )= RegisterPersonInteractorImpl(registerPersonRepositoryImpl)

    @Provides
    @Singleton
    fun provideRegisterPersonPresenterImpl(
        registerPersonInteractorImpl: RegisterPersonInteractorImpl
    ) = RegisterPersonsPresenterImpl(registerPersonInteractorImpl)
}