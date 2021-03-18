package com.quipux.persons.ui.di.module

import com.quipux.persons.data.datasource.cloud.ApiAuthImpl
import com.quipux.persons.data.repository.AuthRepositoryImpl
import com.quipux.persons.domain.interactor.AuthInteractorImpl
import com.quipux.persons.ui.presenter.AuthPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthModule {

    @Provides
    @Singleton
    fun provideApiAuthImpl()= ApiAuthImpl()

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(
        apiAuthImpl: ApiAuthImpl
    ) = AuthRepositoryImpl(apiAuthImpl)

    @Provides
    @Singleton
    fun provideAuthInteractorImpl(
        authRepositoryImpl: AuthRepositoryImpl
    )= AuthInteractorImpl(authRepositoryImpl)

    @Provides
    @Singleton
    fun provideAuthPresenterImpl(
        authInteractorImpl: AuthInteractorImpl
    ) = AuthPresenterImpl(authInteractorImpl)
}